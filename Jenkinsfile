pipeline{
    
    agent any
    tools{
        maven "Maven"
    }
    stages{
        stage("Build maven"){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MdSaddamkhan12/tutorialpoint-product-api-docker-with-jenkins.git']])
                bat "mvn clean install"
            }
        }
        stage("Build Docker image"){
            steps{
                script{
                bat "docker build -t  mdkhansaddam/spring-crud-docker ."
                }
            }
        }
        stage("Push image to Docker Hub"){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerpwdnew', variable: 'docerpwdnew')]) {
                    bat "docker login -u mdkhansaddam -p ${docerpwdnew}"
    
                }
                bat "docker push mdkhansaddam/spring-crud-docker"
                }
            }
        }
    }
}
