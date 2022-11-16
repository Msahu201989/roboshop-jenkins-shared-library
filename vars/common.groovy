def codeQuality() {
    stage('code Quality') {
        steps{
            echo 'code Quality'
            sh 'env'
        }
    }
}