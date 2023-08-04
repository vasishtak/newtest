pipeline {
    agent any 

    tools {
        // Assuming Maven is used for Java project management
        maven 'Maven_3.3.0'  // Replace with your Maven version or tool name
        // Optionally add other tools you might need
    }
      stages {
        stage('Checkout') {
            steps {
                // Check out from the repository
                checkout scm
            }
        }
        
        stage('Unit Tests') {
            steps {
                // Assuming you're using Maven for the Java project. Adjust if you're using something else.
                sh 'mvn clean test'
            }
        }
      }

      post {
        always {
            // Archive the build artifacts and test results
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            junit '**/target/test-*.xml'
        }
        success {
            echo 'Deployment was successful!'
        }
        failure {
            echo 'Deployment failed!'
        }
      }
    }