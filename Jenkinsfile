pipeline {
  agent any
  stages {
    stage('clean') {
      steps {
        powershell 'mvn test -P Regression'
      }
    }

  }
}