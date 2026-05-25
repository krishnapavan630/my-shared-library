def call(String tomcatUrl) {
    echo "Deploying to Tomcat server..."
    deploy adapters: [tomcat9(
        alternativeDeploymentContext: '',
        credentialsId: 'Tomcat-Credentials',
        path: '',
        url: tomcatUrl
    )], contextPath: null, war: '**/*.war'
    echo "✅ Deployed successfully"
}