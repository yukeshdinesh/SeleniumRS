pipeline {
  agent any
  triggers {
        cron('* * * * *')
    }
  stages {
    stage('clean') {
      steps {
        bat 'mvn clean'
      }
    }

    stage('') {
      steps {
        bat 'mvn test -P Tags'
      }
    }

  }
}
