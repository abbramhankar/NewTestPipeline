pipeline {
    agent any
    
    tools {
        maven 'MAVEN_HOME'
        jdk 'JAVA_HOME'
    }

    parameters {
        string(name: 'git_repo_source', defaultValue: 'https://github.com/abbramhankar/NewTestPipeline.git', description: 'Git repository from where we are going to checkout the code (master branch) and build a docker image. NB! The repository must contain a Dockerfile in the root')
        string(name: 'git_repo_branch', defaultValue: 'main', description: 'The branch to be checked out')
        string(name: 'docker_registry_url', defaultValue: '', description: 'Container Registry URL')
        string(name: 'git_credential_Id', defaultValue: 'anantgithub')
        }
    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
        disableConcurrentBuilds()
        timeout(time: 30, unit: 'MINUTES')
    }
    stages {
        stage('Checkout git repo') {
            steps {
                    echo "Checking out code"
                    git branch: '${git_repo_branch}',url: '${git_repo_source}', credentialsId: 'anantgithub'
            }
        }
        stage('Build binary') {
            steps { 
                   bat 'mvn clean install'
            }
        }
        stage('Sonar Analysis') {
            steps {
                   bat 'mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=8aaa2cb5bc634641e0a3a0f3a8635f80855c92c7'
            }
        }
    }
}
