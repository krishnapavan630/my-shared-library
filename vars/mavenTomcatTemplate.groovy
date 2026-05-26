def call(Map config) {
    
    if (!config.gitUrl || !config.tomcatURL) {
        error "mavenPipeline: Both gitURL and tomcat payload URL are required"
    }
    
    def branchName  = config.branchName        ?: 'main'
    def buildCmd    = config.buildCmd      ?: 'mvn clean install'
    def mavenTool   = config.mavenTool     ?: 'mymaven'
    def shouldDeploy = config.deploy != false
    
    pipeline {
        agent any
        
        tools {
            maven "${mavenTool}"
        }
        
        stages {
            stage('SCM Checkout') {
                steps {
                    getRepo(config.gitUrl, branchName)
                }
            }
            
            stage('Build') {
                steps {
                    sh "${buildCmd}"
                }
            }
            
            stage('Deploy') {
                when {
                    expression { shouldDeploy }
                }
                steps {
                    deployToTomcat(config.tomcatURL)
                }
            }
        }
        
        post {
            success {
                echo "Pipeline completed successfully"
            }
            failure {
                echo "Pipeline failed"
            }
        }
    }
}
