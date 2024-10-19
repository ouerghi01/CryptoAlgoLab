// chiffrement par transposition ,rectangulaire



object RectangularTranspositionCipher extends App {

  def chiffrement(S:String,m:Int,n:Int) :String={
    if (S.length != m * n)  return "Invalid input"
    if(m == 1  || n == 1) return S
    var matrix=Array.tabulate(m)(i => S.toArray.slice(i * n, i * n + n)).transpose
    var resulta= ""
    for (j<- matrix.indices){
        resulta+=matrix(j).mkString("")
    }
    return resulta

  }
  def findRectanglePairs(numbers: List[Int], nm: Int):( Int, Int) = {
    var pairs= numbers.sortBy(-_)
    var m=pairs(0)
    var n= -1
    for (i <- 1 until pairs.length-1){
        if (pairs(i)*pairs(i-1)==nm){
            m=pairs(i)
            n=pairs(i-1)
        }
    }
    
    return (m,n)
  }
  def dechiffrement(S:String) :String = {
    val nm=S.length
    println(nm)
    var ls =List[Int]()
    for(j <- 1 until nm+1 ){
        if (nm % j == 0) ls= j :: ls
    }
    println(ls)
    val (m, n) =findRectanglePairs(ls, nm)

    print((m,n))
    
    var matrix=Array.tabulate(n)(i => S.toArray.slice(i * m, i * m + m)).transpose
    

    return matrix.flatten.mkString("")
  }


 // Test cases
 val testCases = List(
  ("illustration", 3, 4), // Example from your code
  ("abcdefg", 1, 7),      // Single row, 7 columns
  ("abcdefgh", 2, 4),     // 2 rows, 4 columns
  ("abcdefghijklmnop", 3, 4), // 3 rows, 4 columns
  ("helloworld", 2, 5)    // 2 rows, 5 columns
)

testCases.foreach { case (input, m, n) =>
  val encrypted = chiffrement(input, m, n)
  val decrypted = dechiffrement(encrypted)
  println(s"Input: '$input', Encrypted: '$encrypted', Decrypted: '$decrypted'")
}

// Additional tests
val additionalTestCases = List(
  ("NMSIOMMLUEALSSRASLSIOEES", 5, 5), // Test with 5x5 matrix
  ("TROUBLESOMEEXAMPLE", 3, 6)         // 3 rows, 6 columns
)

additionalTestCases.foreach { case (input, m, n) =>
  val encrypted = chiffrement(input, m, n)
  val decrypted = dechiffrement(encrypted)
  println(s"Input: '$input', Encrypted: '$encrypted', Decrypted: '$decrypted'")
}

}