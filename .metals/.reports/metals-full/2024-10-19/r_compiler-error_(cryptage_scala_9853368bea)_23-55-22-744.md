file:///C:/Users/wergh/cryptage_scala/Algo.scala
### java.lang.AssertionError: assertion failed: denotation trait Ordering invalid in run 3. ValidFor: Period(4.1-5)

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
uri: file:///C:/Users/wergh/cryptage_scala/Algo.scala
text:
```scala
// chiffrement par transposition ,rectangulaire



object Algo extends App {

  def chiffrement(S:String,m:Int,n:Int) :String={
    if (S.length != m * n)  throw new IllegalArgumentException(s"String length must be exactly ${m * n} characters.")
    var matrix=Array.tabulate(m)(i => S.toArray.slice(i * n, i * n + n)).transpose
    var resulta= ""
    for (j<- matrix.indices){
        resulta+=matrix(j).mkString("")
    }
    return resulta

  }
  def findRectanglePairs(numbers: List[Int], nm: Int):( Int, Int) = {
    var pairs = numbers.sortBy(-_)
    var m=0
    var n=1
    while (m < pairs.length && n < pairs.length) {
      if (pairs(m) * pairs(n) == nm) {
        return (m,n)
      }
      m+=1
      n+=1
    
    }
    return (m,n)
  }
  def dechiffrement(S:String) :String = {
    val nm=S.length
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


  val test1= "illustration"
  val test2=chiffrement(test1,3,4)
  val test3 ="NMSIOMMLUEALSSRASLSIOEES"
  print(dechiffrement(test3))

}
```



#### Error stacktrace:

```
scala.runtime.Scala3RunTime$.assertFailed(Scala3RunTime.scala:8)
	dotty.tools.dotc.core.Denotations$SingleDenotation.updateValidity(Denotations.scala:724)
	dotty.tools.dotc.core.Denotations$SingleDenotation.bringForward(Denotations.scala:749)
	dotty.tools.dotc.core.Denotations$SingleDenotation.toNewRun$1(Denotations.scala:806)
	dotty.tools.dotc.core.Denotations$SingleDenotation.current(Denotations.scala:877)
	dotty.tools.dotc.core.Symbols$Symbol.recomputeDenot(Symbols.scala:124)
	dotty.tools.dotc.core.Symbols$Symbol.computeDenot(Symbols.scala:118)
	dotty.tools.dotc.core.Symbols$Symbol.denot(Symbols.scala:109)
	dotty.tools.dotc.core.Symbols$Symbol.name(Symbols.scala:277)
	dotty.tools.dotc.core.Definitions.asContextFunctionType(Definitions.scala:1919)
	dotty.tools.dotc.typer.ProtoTypes$.normalize(ProtoTypes.scala:890)
	dotty.tools.dotc.typer.Implicits$ImplicitRefs.candidateKind$1(Implicits.scala:235)
	dotty.tools.dotc.typer.Implicits$ImplicitRefs.tryCandidate$1(Implicits.scala:255)
	dotty.tools.dotc.typer.Implicits$ImplicitRefs.filterMatching$$anonfun$2(Implicits.scala:264)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.immutable.List.foreach(List.scala:334)
	dotty.tools.dotc.typer.Implicits$ImplicitRefs.filterMatching(Implicits.scala:264)
	dotty.tools.dotc.typer.Implicits$OfTypeImplicits.eligible(Implicits.scala:285)
	dotty.tools.dotc.typer.Implicits$ImplicitSearch.searchImplicit(Implicits.scala:1689)
	dotty.tools.dotc.typer.Implicits$ImplicitSearch.searchImplicit$$anonfun$2(Implicits.scala:1773)
	dotty.tools.dotc.typer.Implicits$SearchResult.recoverWith(Implicits.scala:430)
	dotty.tools.dotc.typer.Implicits$ImplicitSearch.searchImplicit(Implicits.scala:1759)
	dotty.tools.dotc.typer.Implicits$ImplicitSearch.bestImplicit(Implicits.scala:1800)
	dotty.tools.dotc.typer.Implicits.inferImplicit(Implicits.scala:1109)
	dotty.tools.dotc.typer.Implicits.inferImplicit$(Implicits.scala:860)
	dotty.tools.dotc.typer.Typer.inferImplicit(Typer.scala:145)
	dotty.tools.dotc.typer.Implicits.inferImplicitArg(Implicits.scala:928)
	dotty.tools.dotc.typer.Implicits.inferImplicitArg$(Implicits.scala:860)
	dotty.tools.dotc.typer.Typer.inferImplicitArg(Typer.scala:145)
	dotty.tools.dotc.typer.Typer.implicitArgs$1(Typer.scala:4071)
	dotty.tools.dotc.typer.Typer.addImplicitArgs$1(Typer.scala:4143)
	dotty.tools.dotc.typer.Typer.adaptNoArgsImplicitMethod$1(Typer.scala:4199)
	dotty.tools.dotc.typer.Typer.adaptNoArgs$1(Typer.scala:4406)
	dotty.tools.dotc.typer.Typer.adapt1(Typer.scala:4660)
	dotty.tools.dotc.typer.Typer.adapt(Typer.scala:3932)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3554)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3558)
	dotty.tools.dotc.typer.Typer.typedExpr(Typer.scala:3669)
	dotty.tools.dotc.typer.Namer.typedAheadExpr$$anonfun$1(Namer.scala:1747)
	dotty.tools.dotc.typer.Namer.typedAhead(Namer.scala:1737)
	dotty.tools.dotc.typer.Namer.typedAheadExpr(Namer.scala:1747)
	dotty.tools.dotc.typer.Namer.typedAheadRhs$1$$anonfun$1(Namer.scala:2073)
	dotty.tools.dotc.inlines.PrepareInlineable$.dropInlineIfError(PrepareInlineable.scala:256)
	dotty.tools.dotc.typer.Namer.typedAheadRhs$1(Namer.scala:2073)
	dotty.tools.dotc.typer.Namer.rhsType$1(Namer.scala:2081)
	dotty.tools.dotc.typer.Namer.cookedRhsType$1(Namer.scala:2100)
	dotty.tools.dotc.typer.Namer.lhsType$1(Namer.scala:2101)
	dotty.tools.dotc.typer.Namer.inferredResultType(Namer.scala:2112)
	dotty.tools.dotc.typer.Namer.inferredType$1(Namer.scala:1779)
	dotty.tools.dotc.typer.Namer.valOrDefDefSig(Namer.scala:1785)
	dotty.tools.dotc.typer.Namer$Completer.typeSig(Namer.scala:823)
	dotty.tools.dotc.typer.Namer$Completer.completeInCreationContext(Namer.scala:974)
	dotty.tools.dotc.typer.Namer$Completer.complete(Namer.scala:850)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.completeFrom(SymDenotations.scala:175)
	dotty.tools.dotc.core.Denotations$Denotation.completeInfo$1(Denotations.scala:190)
	dotty.tools.dotc.core.Denotations$Denotation.info(Denotations.scala:192)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.ensureCompleted(SymDenotations.scala:393)
	dotty.tools.dotc.typer.Typer.retrieveSym(Typer.scala:3339)
	dotty.tools.dotc.typer.Typer.typedNamed$1(Typer.scala:3364)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3476)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3554)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3558)
	dotty.tools.dotc.typer.Typer.traverse$1(Typer.scala:3580)
	dotty.tools.dotc.typer.Typer.typedStats(Typer.scala:3626)
	dotty.tools.dotc.typer.Typer.typedBlockStats(Typer.scala:1377)
	dotty.tools.dotc.typer.Typer.typedBlock(Typer.scala:1381)
	dotty.tools.dotc.typer.Typer.typedUnnamed$1(Typer.scala:3400)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3477)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3554)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3558)
	dotty.tools.dotc.typer.Typer.typedExpr(Typer.scala:3669)
	dotty.tools.dotc.typer.Typer.$anonfun$64(Typer.scala:2816)
	dotty.tools.dotc.inlines.PrepareInlineable$.dropInlineIfError(PrepareInlineable.scala:256)
	dotty.tools.dotc.typer.Typer.typedDefDef(Typer.scala:2816)
	dotty.tools.dotc.typer.Typer.typedNamed$1(Typer.scala:3374)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3476)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3554)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3558)
	dotty.tools.dotc.typer.Typer.traverse$1(Typer.scala:3580)
	dotty.tools.dotc.typer.Typer.typedStats(Typer.scala:3626)
	dotty.tools.dotc.typer.Typer.typedClassDef(Typer.scala:3074)
	dotty.tools.dotc.typer.Typer.typedTypeOrClassDef$1(Typer.scala:3380)
	dotty.tools.dotc.typer.Typer.typedNamed$1(Typer.scala:3384)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3476)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3554)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3558)
	dotty.tools.dotc.typer.Typer.traverse$1(Typer.scala:3580)
	dotty.tools.dotc.typer.Typer.typedStats(Typer.scala:3626)
	dotty.tools.dotc.typer.Typer.typedPackageDef(Typer.scala:3207)
	dotty.tools.dotc.typer.Typer.typedUnnamed$1(Typer.scala:3426)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3477)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3554)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3558)
	dotty.tools.dotc.typer.Typer.typedExpr(Typer.scala:3669)
	dotty.tools.dotc.typer.TyperPhase.typeCheck$$anonfun$1(TyperPhase.scala:47)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	dotty.tools.dotc.core.Phases$Phase.monitor(Phases.scala:503)
	dotty.tools.dotc.typer.TyperPhase.typeCheck(TyperPhase.scala:53)
	dotty.tools.dotc.typer.TyperPhase.$anonfun$4(TyperPhase.scala:99)
	scala.collection.Iterator$$anon$6.hasNext(Iterator.scala:479)
	scala.collection.Iterator$$anon$9.hasNext(Iterator.scala:583)
	scala.collection.immutable.List.prependedAll(List.scala:152)
	scala.collection.immutable.List$.from(List.scala:685)
	scala.collection.immutable.List$.from(List.scala:682)
	scala.collection.IterableOps$WithFilter.map(Iterable.scala:900)
	dotty.tools.dotc.typer.TyperPhase.runOn(TyperPhase.scala:98)
	dotty.tools.dotc.Run.runPhases$1$$anonfun$1(Run.scala:343)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.ArrayOps$.foreach$extension(ArrayOps.scala:1323)
	dotty.tools.dotc.Run.runPhases$1(Run.scala:336)
	dotty.tools.dotc.Run.compileUnits$$anonfun$1(Run.scala:384)
	dotty.tools.dotc.Run.compileUnits$$anonfun$adapted$1(Run.scala:396)
	dotty.tools.dotc.util.Stats$.maybeMonitored(Stats.scala:69)
	dotty.tools.dotc.Run.compileUnits(Run.scala:396)
	dotty.tools.dotc.Run.compileSources(Run.scala:282)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:161)
	dotty.tools.pc.MetalsDriver.run(MetalsDriver.scala:47)
	dotty.tools.pc.PcCollector.<init>(PcCollector.scala:42)
	dotty.tools.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:88)
	dotty.tools.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:109)
```
#### Short summary: 

java.lang.AssertionError: assertion failed: denotation trait Ordering invalid in run 3. ValidFor: Period(4.1-5)