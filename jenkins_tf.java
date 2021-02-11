import groovy.json.JsonSlurper
@Library('github.com/releaseworks/jenkinslib') _ 
String CODE_REPO = "https://github.com/rahulcmr11/terraform-demo.git" // clone this git repo
node {

    ws("terraform-demo-demo") {    // workspace for server

        stage('checkout-git') {

           checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'demo-terraform', url: CODE_REPO]]]

        }
	    
	    stage('check_init_plan') {  // run terraform init and plan only which does not make any changes but gives overview
		
		sh '''
			cd ec2-s3
			sudo terraform init 
			sudo terraform plan
			
			 
		'''    
		println("All look good . Please run the terraform apply ")	
        }
	    
	    stage('apply_the_plan') {   // after success of above stage run the apply
		    
	sh '''
	    cd ec2-s3
	    sudo terraform apply -auto-approve # apply the terraform
	    sudo cp /var/lib/jenkins/terraform-demo-demo/ec2-s3/terraform.tfstate /var/lib/jenkins/terraform-demo-demo/terraform-demo/ec2-s3/terraform.tfstate

			 
	  '''
			
        }
	stage('tf_state_file') {   // after success of above stage run the apply
		    
	sh '''
	    sudo cd /var/lib/jenkins/terraform-demo-demo/terraform-demo/ec2-s3/
	    sudo git add terraform.tfstate
	    sudo git commit -m "After apply run"
	    sudo git push
	    
			 
	  '''
			
        }    
        }
        }

