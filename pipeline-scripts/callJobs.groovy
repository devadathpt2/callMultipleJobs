pipeline {
    agent any
    stages {
        stage("checkout SCM")
                {
                    steps {
                        cleanWs()
                        checkout([$class: 'GitSCM', branches: [[name: '*/master']],
                                  doGenerateSubmoduleConfigurations: false,
                                  extensions: [], submoduleCfg: [],
                                  userRemoteConfigs: [[url: 'https://github.com/devadathpt2/callMultipleJobs']]])
                    }
                }
        stage('Load')
                {

                    steps {
                        script {
                            def code = load "pipeline-scripts/listOfJobs.groovy"
                            jobs = code.listProjectItems()

                        }
                    }
                }


        stage ("build") {		//an arbitrary stage name

            steps {
                script {
                    println(jobs)
                    for ( job in jobs.tokenize(','))
                    {
                        build job: job , parameters: [[$class: 'StringParameterValue' , name: 'targetEnv', value: "prod"]]

                    }
                }
            }
        }
    }
}
