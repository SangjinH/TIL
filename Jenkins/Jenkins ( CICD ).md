#  <img src="C:\Users\multicampus\AppData\Roaming\Typora\typora-user-images\image-20210702123411445.png" alt="image-20210702123411445" style="zoom:25%;" />     Jenkins ( CI/CD )

> 들어가기에 앞서 CI / CD 를 가장 편하게 사용하기 위한 툴로 Jenkins를 사용한다.
>
> > CI : Continuous Integration
> >
> > CD: Continuous Deploy / Delivery



1. 구성환경
   - AWS EC2 ( 리눅스환경 제공 ) 
   - Jenkins ( CI/CD 자동화 Pipeline 구축 )
   - Git
   - AWS S3 ( 기본 Storage )



2. 실제 파일의 모양
   - 순서
     1. `trigger`
     2. `stages` 안에 `stage` 여러개 
        1. `Prepare`
        2. `Deploy FrontEnd`
        3. `Lint Backend`
        4. `Test Backend`
        5. `Build Backend`
        6. `Deploy Backend`

```
pipeline {
    // 스테이지 별로 다른 거
    agent any

	// 실행되는 빈도
    triggers {
        pollSCM('*/3 * * * *')
    }
    
	// 환경설정
    environment {
      AWS_ACCESS_KEY_ID = credentials('awsAccessKeyId')
      AWS_SECRET_ACCESS_KEY = credentials('awsSecretAccessKey')
      AWS_DEFAULT_REGION = 'ap-northeast-2'
      HOME = '.' // Avoid npm root owned
    }
 	
 	// 단계
    stages {
        // 레포지토리를 다운로드 받음
        stage('Prepare') {
            agent any
            
            steps {
                echo 'Clonning Repository'

                git url: 'https://github.com/SangjinH/Deploy_with_Jenkins',
                    branch: 'master',
                    credentialsId: 'gittest'
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    echo 'Successfully Cloned Repository'
                }

                always {
                  echo "i tried..."
                }

                cleanup {
                  echo "after all other post condition"
                }
            }
        }
        
        // aws s3 에 파일을 올림
        stage('Deploy Frontend') {
          steps {
            echo 'Deploying Frontend'
            // 프론트엔드 디렉토리의 정적파일들을 S3 에 올림, 이 전에 반드시 EC2 instance profile 을 등록해야함.
            dir ('./website'){
                sh '''
                aws s3 sync ./ s3://sangjinhan
                '''
            }
          }

          post {
              // If Maven was able to run the tests, even if some of the test
              // failed, record the test results and archive the jar file.
              success {
                  echo 'Successfully Cloned Repository'


              }

              failure {
                  echo 'I failed :('
              }
          }
        }
        
        stage('Lint Backend') {
            // Docker plugin and Docker Pipeline 두개를 깔아야 사용가능!
            agent {
              docker {
                image 'node:latest'
              }
            }
            
            steps {
              dir ('./server'){
                  sh '''
                  npm install&&
                  npm run lint
                  '''
              }
            }
        }
        
        stage('Test Backend') {
          agent {
            docker {
              image 'node:latest'
            }
          }
          steps {
            echo 'Test Backend'

            dir ('./server'){
                sh '''
                npm install
                npm run test
                '''
            }
          }
        }
        
        stage('Bulid Backend') {
          agent any
          steps {
            echo 'Build Backend'

            dir ('./server'){
                sh """
                docker build . -t server --build-arg env=${ENV}
                """
            }
          }

          post {
            failure {
              error 'This pipeline stops here...'
            }
          }
        }
        
        stage('Deploy Backend') {
          agent any

          steps {
            echo 'Build Backend'

            dir ('./server'){
                sh '''
                docker rm -f $(docker ps -aq)
                docker run -p 80:80 -d server
                '''
            }
          }

          post {
            success {
              echo 'Build Success'
                  
            }
          }
        }
    }
}

```



