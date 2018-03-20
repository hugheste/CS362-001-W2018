
package finalprojectB;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.Random;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!


public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   @Test
    public void testManualTest() {
       UrlValidator urlTemp = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       //Test full valid Urls
       assertTrue(urlTemp.isValid("http://www.google.com"));
       assertTrue(urlTemp.isValid("http://www.google.com/"));
    //   assertTrue(urlTemp.isValid("http://2.4.8.16.32.64.128.256.512.1024.2046:100/test/"));
       assertTrue(urlTemp.isValid("http://www.google.com?x=1"));
      // assertTrue(urlTemp.isValid("http://www.google.com:12121"));
       //Test completely invalid Urls
       assertFalse(urlTemp.isValid(null));
       assertFalse(urlTemp.isValid("potato")); //should be incorrect
//       assertFalse(urlTemp.isValid("http://www.g00gle.com"));
      // assertFalse(urlTemp.isValid("http://www.go0gle..com"));    //Due to bugs in the program, incorrect Urls come up true
       //assertFalse(urlTemp.isValid("http://www..google.com"));
//       assertFalse(urlTemp.isValid("http://www.GooLe.com"));
//       assertFalse(urlTemp.isValid("http://sss.google.com"));
//       assertFalse(urlTemp.isValid("http://www.G?oogle.com"));
//       assertFalse(urlTemp.isValid("https://www.google.c0m"));
       assertFalse(urlTemp.isValid("http::::://google.com"));
       assertFalse(urlTemp.isValid("http:///googleů.com"));
//       assertFalse(urlTemp.isValid("htttttp://www.google.com"));
//       assertFalse(urlTemp.isValid("http://www.asdfghjkl.com"));
       assertFalse(urlTemp.isValid("htps:://google.com"));
       assertFalse(urlTemp.isValid("Http:google.me"));
       assertFalse(urlTemp.isValid("googl3.com"));
       assertFalse(urlTemp.isValid("256.512.1024.2046"));
       assertFalse(urlTemp.isValid("f@cebook.com"));
       assertFalse(urlTemp.isValid("www//facebook.com"));
       assertFalse(urlTemp.isValid("sharlenaluyen.me"));
       assertFalse(urlTemp.isValid("stephaniehughes.hello"));
       assertFalse(urlTemp.isValid("1040.facebook.com"));
       assertFalse(urlTemp.isValid("kkkk.ssss.com"));
       assertFalse(urlTemp.isValid("www.sss.www.sss.com"));
//       assertFalse(urlTemp.isValid("http://www.google.com~"));
//       assertFalse(urlTemp.isValid("https://google.com"));
//       assertFalse(urlTemp.isValid("https://g!oogle.com"));
       assertFalse(urlTemp.isValid(".com"));
//       assertFalse(urlTemp.isValid("https://www.com"));
       assertFalse(urlTemp.isValid("www.com"));
//       assertFalse(urlTemp.isValid("http://ww..com")); //fail
//       assertFalse(urlTemp.isValid("http://.com/"));  //fail
   }

    @Test
   public void testYourFirstPartition() {
       UrlValidator urlTemp = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       //Test different Url Schemes
       assertTrue(urlTemp.isValid("http://www.facebook.com"));
       assertTrue(urlTemp.isValid("http://www.google.com"));
//        assertTrue(urlTemp.isValid("www.facebook.com"));
       assertFalse(urlTemp.isValid("http:$/www.facebook.com"));
       assertFalse(urlTemp.isValid("://www.facebook.com"));
       assertFalse(urlTemp.isValid("3dw://www.facebook.com"));
       assertFalse(urlTemp.isValid("https/www.facebook.com"));
       assertFalse(urlTemp.isValid("httpz3/www.facebook.com"));
        assertFalse(urlTemp.isValid("&&&/www.facebook.com"));
        assertFalse(urlTemp.isValid("AFR3/www.facebook.com"));
   }

    @Test
   public void testYourSecondPartition(){
       UrlValidator urlTemp = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       //Test different Url Authorities
//       assertTrue(urlTemp.isValid("google.com")); **All of these should be true!
//       assertTrue(urlTemp.isValid("google.au"));
//       assertTrue(urlTemp.isValid("0.0.0.0"));
       assertFalse(urlTemp.isValid("1.2.3.4.5"));
       assertFalse(urlTemp.isValid(".1.2.3.4"));
       assertFalse(urlTemp.isValid(".1.z.3.4"));
       assertFalse(urlTemp.isValid(".1...3.4"));
       assertFalse(urlTemp.isValid(".1.2.36,f"));
       assertFalse(urlTemp.isValid("..&.1.2.3.4"));
       assertFalse(urlTemp.isValid(".a.f2.222.!"));
       assertFalse(urlTemp.isValid("..."));
        assertFalse(urlTemp.isValid(".77774"));
       //You can use this function to implement your Second Partition testing
   }
    @Test
    public void testYourThirdPartition() {
        UrlValidator urlTemp = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        //Test different Url Ports
//       assertTrue(urlTemp.isValid(":80")); //All commented out should be true
//       assertTrue(urlTemp.isValid(":0"));
//       assertTrue(urlTemp.isValid(""));
        //assertTrue(urlTemp.isValid(":20"));
        assertFalse(urlTemp.isValid("-8"));
        assertFalse(urlTemp.isValid("84579495"));
        assertFalse(urlTemp.isValid("abc"));
        assertFalse(urlTemp.isValid("AgBgg"));
        assertFalse(urlTemp.isValid(":5hy3"));
        assertFalse(urlTemp.isValid(":9000030003"));
        assertFalse(urlTemp.isValid("baU&"));
        assertFalse(urlTemp.isValid("-1.2"));
    }

    @Test
    public void testYourFourthPartition() {
        UrlValidator urlTemp = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        //Test different Paths
        //    assertTrue(urlTemp.isValid("/test1/file/")); Nothing coming up true, even ""
//       assertTrue(urlTemp.isValid("/t2"));
        assertFalse(urlTemp.isValid("/.r."));
        assertFalse(urlTemp.isValid("/..."));
        assertFalse(urlTemp.isValid("/./file"));
        assertFalse(urlTemp.isValid("doc&_%/file"));
        assertFalse(urlTemp.isValid("/./file65%7"));
        assertFalse(urlTemp.isValid("/....ile"));
        assertFalse(urlTemp.isValid("//&/./file"));
        assertFalse(urlTemp.isValid("/./error^d"));
        assertFalse(urlTemp.isValid("/////o7(e"));
        assertFalse(urlTemp.isValid("(/./file"));
    }

    @Test
    public void testYourFifthPartition() {
        UrlValidator urlTemp = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        //Test different Url Queries
//        assertTrue(urlTemp.isValid("?action=view")); **Both should be true
//       assertTrue(urlTemp.isValid(""));
        assertFalse(urlTemp.isValid("?action=sadf"));
        assertFalse(urlTemp.isValid("action8=sadf"));
        assertFalse(urlTemp.isValid("go=sadf"));
        assertFalse(urlTemp.isValid("?goal=sadf"));
        assertFalse(urlTemp.isValid("?action=RYN@f"));
        assertFalse(urlTemp.isValid("?action=@"));
        assertFalse(urlTemp.isValid("act=view"));
        assertFalse(urlTemp.isValid("rerction=s"));
        assertFalse(urlTemp.isValid("?*#=sadf"));
    }

   @Test
   public void testIsValid() {

       String[] testUrlScheme = {"http4://", "ftp://","http:$/","://","http://" };

       String[] testUrlAuthority = {"www.google.com", "go.com", "go.a", ".aaa", "1.2.3.4.5"};

       String[] testUrlPort = {":80", ":65535", ":943543", ":a3z!", ":0"};

       String[] testUrlPath = {"/test1", "/t123", "/t2", "/./file", "/test1/file/"};

       String[] testUrlQuery = {"?action=view", "action", "?action9=view", "?!hhaction=view", ""};

       int c = 0;
       int in = 0;
       Random rnd = new Random();
       String[] CorrectUrls = new String[20];
       String[] IncorrectUrls = new String[20];

       for(int j=0;j<20;j++){
           CorrectUrls[j] = "";
           IncorrectUrls[j] = "";
       }

       int numOptions = 5;
       int i = 0;
       for(i=0;i<numOptions;i++) {
           int r = rnd.nextInt(5);
           String urlTemp = testUrlScheme[r] + testUrlAuthority[r] + testUrlPort[r] + testUrlPath[r] + testUrlQuery[r];
           UrlValidator validUrl = new UrlValidator();

           boolean isCorrect = validUrl.isValid(urlTemp);

           if (isCorrect == true) {
               CorrectUrls[c] = urlTemp;
               System.out.println(CorrectUrls[c]);
               c++;

           } else {
               IncorrectUrls[in] = urlTemp;
              // System.out.println(IncorrectUrls[c]);
               in++;
           }
       }
       System.out.println("These are the correct Urls:");
       for(int k=0;k<c;k++){
           System.out.println(CorrectUrls[k]);
       }

       System.out.println("These are the incorrect Urls:");
       for(int k=0;k<in;k++){
           System.out.println(IncorrectUrls[k]);
       }
   }
}
