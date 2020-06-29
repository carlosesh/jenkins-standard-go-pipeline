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
          sh 'go build'
        }
      }
      stage('Test') {
        steps {
          echo "Running Tests"
          echo "The environment variable for this stage is: ${ENV_VAR_PSRNL}"
          sh 'go test -cover'
        }
      }
    }
  }
}
