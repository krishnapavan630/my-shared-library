def call(){
    echo "Starting Maven build..."
    sh 'mvn clean install'
    echo "Build completed"
}