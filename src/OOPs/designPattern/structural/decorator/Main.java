package OOPs.designPattern.structural.decorator;

/**
 * Adding different behaviours dynamically to the existing object by hiding
 * other classes and methods
 * StoreCreditCardInfo method takes a stream object as argument, delegate the request to its
 * target object that defined in the class using composition
 */
public class Main {
    public static void main(String[] args) {
        storeCreditCardInfo(new CloudStream());
        storeCreditCardInfo(new EncryptedCloudStream(new CloudStream()));
        //passing the different Stream objects to compress and encrypt
        storeCreditCardInfo(new EncryptedCloudStream(new CompressCloudStream(new CloudStream())));

    }
    public static void storeCreditCardInfo(Stream stream){
        stream.write("1234-1234-1234-1234");
    }
}
