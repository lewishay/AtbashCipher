/**
  * Created by Administrator on 19/07/2017.
  */
class CipherTests extends CipherSpec {
  val atbash = new Atbash

  "The encode function" should "encode a given word with the Atbash cipher" in {
    assert(atbash.encode("Secrets") === "hvxivgh")
    assert(atbash.encode("password") === "kzhhdliw")
    assert(atbash.encode("The British are coming") === "gsv yirgrhs ziv xlnrmt")
  }

  "The decode function" should "decode a given word with the Atbash cipher" in {
    assert(atbash.decode("ullyzi") === "foobar")
    assert(atbash.decode("draziw") === "wizard")
    assert(atbash.decode("gsrh rh zm vcznkov lu gsv zgyzhs xrksvi") === "this is an example of the atbash cipher")
  }

  "A word" should "be the same after encoding and decoding, although decoding only returns lower case results)" in {
    assert(atbash.decode(atbash.encode("password")) === "password")
    assert(atbash.decode(atbash.encode("hidden message")) === "hidden message")
    assert(atbash.decode(atbash.encode("soMe caPItaLs")) !== "soMe caPItaLs")
  }

  "Unsupported characters" should "convert to the # character" in {
    assert(atbash.decode(atbash.encode("hey!!!")) !== "hey!!!")
    assert(atbash.decode(atbash.encode("£money$")) === "#money#")
    assert(atbash.decode(atbash.encode("ordinary[characters]")) === "ordinary#characters#")
  }
}
