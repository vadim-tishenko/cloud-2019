import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

public class S3App {
    public static void main(String[] args) {
        Region region = Region.EU_NORTH_1;
        S3Client s3 = S3Client.builder().region(region).build();
//        String bucket = "bucket" + System.currentTimeMillis();
//        System.out.println(bucket);

// Create bucket
/*CreateBucketRequest createBucketRequest = CreateBucketRequest
                .builder()
                .bucket(bucket)
                .createBucketConfiguration(CreateBucketConfiguration.builder()
                        .locationConstraint(region.id())
                        .build())
                .build();
        s3.createBucket(createBucketRequest);*/
//        ListBucketsRequest listBucketsRequest = ListBucketsRequest.builder().build();
//        for (int i = 0; i < 5; i++) {
//            ListBucketsResponse listBucketsResponse = s3.listBuckets(listBucketsRequest);
//
//            final List<Bucket> buckets = listBucketsResponse.buckets();
//            final int size = buckets.size();
//
//            System.out.println(buckets);
//
//            listBucketsResponse.buckets().stream().forEach(x -> System.out.println(x.name()));
//        }

        for (int i = 0; i <3 ; i++) {
            long start = System.currentTimeMillis();

            ResponseBytes<GetObjectResponse> rr = s3.getObject(GetObjectRequest.builder().bucket("bucket1571063009669").key("key_1571067055984").build(),
                    ResponseTransformer.toBytes());
            System.out.println(rr.asByteArray().length);
            long finish = System.currentTimeMillis();

            System.out.println(finish - start);
        }


//        ListObjectsV2Response ee = s3.listObjectsV2(ListObjectsV2Request.builder()
//                .bucket("bucket1571063009669").prefix()
////                .maxKeys(1)
//                .build());
//        for (S3Object content : ee.contents()) {
//            System.out.println(content.key());
//        }

//        for (int j = 0; j < 5; j++) {
//            s3.putObject(PutObjectRequest.builder().bucket("bucket1571063009669").key("key_" + System.currentTimeMillis()).build(),
//                    RequestBody.fromBytes(getRandomByteBuffer(10_000)));
//        }
    }

    private static byte[] getRandomByteBuffer(int size) {
        return new byte[size];
    }
}
