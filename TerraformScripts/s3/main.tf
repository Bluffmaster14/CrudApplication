resource "aws_s3_bucket" "Dev" {
  bucket = var.bucket_name
  tags = {
    Environment = "Dev"
  }
}

variable "bucket_name" {
  description = "The name of the S3 bucket"
  type        = string
}

output "name" {
  value = aws_s3_bucket.Dev.bucket
}