pipeline {
  agent any
  triggers {
        cron('H * * * *')
    }
  parameters {
  choice choices: ['Regression', 'Smoke', 'Sanity'], name: 'Tags'
}
  stages {
    stage('clean') {
      steps {
        bat 'mvn clean'
      }
    }

    stage('') {
      steps {
        bat "mvn test -P ${params.Tags}"
      }
    }

  }
}
