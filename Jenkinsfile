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
                  }
            }


    















        }

    }
