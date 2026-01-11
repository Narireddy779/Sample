pipeline {
    agent any

    tools {
        maven 'Maven-3.9'
    }

    stages {

        stage('Build Maven') {
            steps {
                git branch: 'dev',
                    credentialsId: 'eed11b8a-62f0-4e5a-96e3-55fcc9d55803',
                    url: 'https://github.com/Narireddy779/Sample'

                dir('sample') {
                    bat 'mvn clean install'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                dir('sample') {
                    bat 'docker build -t sample-app:1.0 .'
                }
            }
        }

        stage('Push Docker Hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhub_password')]) {

                        // DockerHub CLI login (USERNAME, not email)
                        bat 'docker login -u gamer7463 -p %dockerhub_password%'

                        // Tag image for DockerHub
                        bat 'docker tag sample-app:1.0 gamer7463/builddockerviajenkins'

                        // Push image
                        bat 'docker push gamer7463/builddockerviajenkins'
                    }
                }
            }
        }
    }

    post {
        success {
            echo '✅ Build, Docker image creation, and push to DockerHub SUCCESSFUL'
        }
        failure {
            echo '❌ Pipeline FAILED'
        }
    }
}
