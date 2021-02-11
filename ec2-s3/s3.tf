provider "aws" {                                  ### provider is aws, can be azure , google etc.
 region = "us-east-2"                             ### region to create aws resources.
 shared_credentials_file = "/home/ubuntu/rahul-demo/credentials"   ### Credetials to connect aws and terraform cli stored in file
 profile = "TF"                                   ### profile name of saved aws credentials 
}

## 2nd resource s3 bucket
resource "aws_s3_bucket" "b" {
  bucket = "demo-tf-09022021-terraform3"                                  ##bucket name , change for demo                       
  acl    = "private"

  tags = {
    Name        = "My bucket"                      ### Tags
    Environment = "Dev"                            ### Name of envoirnment, dev prof etc
  }
}
