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
  stage('MVN COMPILE') {
               steps {
                   bat 'mvn compile'
                               }
                     }

   stage('MVN PACKAGE') {
               steps {
                   bat 'mvn package'
                          }
                      }
                      stage('MVN TEST') {
                                                    steps {
                                                        bat 'mvn test'
                                                    }
                                                }

                                                 stage('SonarQube Analysis') {

                                                                    steps{
                                                                    bat 'mvn clean verify sonar:sonar \
                                                                           -Dsonar.projectKey=p1 \
                                                                           -Dsonar.host.url=http://localhost:9000 \
                                                                           -Dsonar.login=sqp_418ea11ea269826d514212be85da931980ffc4bb'
                                                                    }

                                                                  }

                            stage('Docker login') {

                                                                             steps {
                                                                               bat 'echo "login Docker ...."'
                                                                               bat 'docker login -u hedibj -p AZErty123@'
                                                                                          }  }





      }
    }
