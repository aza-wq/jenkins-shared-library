#!/usr/bin/env groovy

def call () {

    echo "building docker image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {

        sh 'docker build -t azasdocker/demo-app:jma-2.0 . '
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push azasdocker/demo-app:jma-2.0'

    }
}

