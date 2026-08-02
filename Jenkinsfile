pipeline {
    agent any
	tools {
	maven 'Maven-3'
}

    stages {
        stage('Check Tools') {
            steps {
                echo 'Checking Tools'
		sh 'java -version'
		sh 'mvn -version'
            }
        }

        stage('Compile') {
            steps {
                echo 'Compile the Application'
		sh 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing the Application'
		sh 'mvn test'

            }
        }
        stage('Package') {
            steps {
                echo 'Package the Application'
		sh 'mvn package'
            }
        }
    }
}
