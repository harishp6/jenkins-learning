pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the Application'
		sh 'cat app.txt'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing the Application'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying the Application'
            }
        }
        stage('Where am I?') {
            steps {
                sh 'pwd'
                sh 'whoami'
                sh 'ls'
                sh 'ls -la'
            }
        }
    }
}
