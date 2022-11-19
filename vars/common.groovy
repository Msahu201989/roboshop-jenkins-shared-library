def codeCheckout() {
 stage('code checkout') {
   sh 'find . | sed 1d |xargs rm -rf'
   git branch: 'main', url: "https://github.com/Msahu201989/${COMPONENT}.git"
 }
}


def codeQuality() {
    stage('Code Quality') {
        withCredentials([usernamePassword(credentialsId: 'SONAR', passwordVariable: 'sonarPass', usernameVariable: 'sonarUser')]) {
            sh '''
           sonar-scanner -Dsonar.host.url=http://172.31.14.33:9000 -Dsonar.login=${sonarUser} -Dsonar.password=${sonarPass} -Dsonar.projectKey=${COMPONENT} -Dsonar.qualitygate.wait=true
       '''
        }
    }
 }

def codeChecks() {
    if ( env.BRANCH_NAME == "main" || TAG_NAME ==~ ".*" ) {

        stage('Style Checks') {
            echo 'Style Checks'
        }

        stage('Unit Tests') {
            echo 'unit Tests'
        }
    }
}

def artifacts() {
    if ( env.TAG_NAME ==~ ".*" ) {

        stage('Download Dependencies') {
            echo 'Download Dependencies'
        }
       stage('Prepare  Artifacts') {
           echo 'Prepare Artifacts'
       }

        stage('Publish Artifacts') {
         echo 'Publish Artifacts'
        }
        }
    }

