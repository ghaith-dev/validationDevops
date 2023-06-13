pipeline {
    agent any
     tools {
          maven 'maven'

        }
    stages {
        stage('Clean') {
            steps {

                       sh  'mvn clean'



            }
            }


   stage('Compile') {
            steps {

                       sh  'mvn compile'



            }
            }

    stage('Test') {
            steps {

                       sh  'mvn test'


                        }}
                        stage("Sonar Analysis") {
                        def mvn = tool 'Default Maven';
                            withSonarQubeEnv() {
                              sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=Devops"
                        }















        }

    }
