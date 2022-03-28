pipeline {
  agent any
  properties([parameters([choice(choices: ['Regression', 'Sanity', 'Smoke'], name: 'Tags')])])
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
