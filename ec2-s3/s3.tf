

## 2nd resource s3 bucket
resource "aws_s3_bucket" "b" {
  bucket = "demo-tf-09022021-terraform4"                                  ##bucket name , change for demo                       
  acl    = "private"

  tags = {
    Name        = "My bucket"                      ### Tags
    Environment = "Dev"                            ### Name of envoirnment, dev prof etc
  }
}
