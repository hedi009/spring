pipeline {
    agent any
    stages {
        stage('Checkout GIT') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: 'main']],
                    userRemoteConfigs: [[url: 'https://github.com/hedi009/spring.git']]
                ])
            }
        }
  stage('MVN CLEAN') {
              steps {
                 withMaven() {
                bat 'mvn clean compile'

             }
           }
          }




      }
    }
