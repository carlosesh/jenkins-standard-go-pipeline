def call() {
	pipeline {
    agent {
      docker {
        image 'golang:1.14-alpine'
      }
    }
    environment { 
        HOME = '.'
        ENV_VAR_PSRNL = 'HI! This is the ENV VAR'
    }

    stages {
      stage('Build') {
        steps {
          echo "Running build ${env.BUILD_ID} on ${env.JENKINS_URL}"
          sh 'go build'
        }
      }
      stage('Test') {
        steps {
          echo "Running Tests"
          echo "The environment variable for this stage is: ${ENV_VAR_PSRNL}"
          echo "First Name is: ${firstName}"
          sh 'go test -cover'
        }
      }
    }
  }
}
