file:///C:/Users/wergh/cryptage_scala/Algo.scala
### java.lang.AssertionError: assertion failed: denotation module class Throwable$ invalid in run 3. ValidFor: Period(4.1-2)

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
	dotty.tools.dotc.core.Symbols$ClassSymbol.classDenot(Symbols.scala:531)
	dotty.tools.dotc.core.Symbols$.toClassDenot(Symbols.scala:547)
	dotty.tools.dotc.core.unpickleScala2.Scala2Unpickler$.setClassInfo(Scala2Unpickler.scala:113)
	dotty.tools.dotc.core.classfile.ClassfileParser.parseClass(ClassfileParser.scala:416)
	dotty.tools.dotc.core.classfile.ClassfileParser.$anonfun$1(ClassfileParser.scala:302)
	dotty.tools.dotc.core.classfile.ClassfileParser.run(ClassfileParser.scala:297)
	dotty.tools.dotc.core.ClassfileLoader.doComplete(SymbolLoaders.scala:417)
	dotty.tools.dotc.core.SymbolLoader.complete(SymbolLoaders.scala:348)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.completeFrom(SymDenotations.scala:175)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.completeOnce(SymDenotations.scala:385)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.unforcedDecls(SymDenotations.scala:409)
	dotty.tools.dotc.core.SymDenotations$ClassDenotation.typeParamsFromDecls(SymDenotations.scala:1896)
	dotty.tools.dotc.core.SymDenotations$ClassDenotation.typeParams(SymDenotations.scala:1909)
	dotty.tools.dotc.core.classfile.ClassfileParser$$anon$2.apply(ClassfileParser.scala:66)
	dotty.tools.dotc.core.classfile.ClassfileParser$$anon$2.apply(ClassfileParser.scala:65)
	scala.collection.immutable.List.mapConserve(List.scala:473)
	dotty.tools.dotc.core.classfile.ClassfileParser$$anon$2.apply(ClassfileParser.scala:75)
	dotty.tools.dotc.core.classfile.ClassfileParser$AttributeCompleter.complete(ClassfileParser.scala:928)
	dotty.tools.dotc.core.classfile.ClassfileParser.parseClass(ClassfileParser.scala:418)
	dotty.tools.dotc.core.classfile.ClassfileParser.$anonfun$1(ClassfileParser.scala:302)
	dotty.tools.dotc.core.classfile.ClassfileParser.run(ClassfileParser.scala:297)
	dotty.tools.dotc.core.ClassfileLoader.doComplete(SymbolLoaders.scala:417)
	dotty.tools.dotc.core.SymbolLoader.complete(SymbolLoaders.scala:348)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.completeFrom(SymDenotations.scala:175)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.completeOnce(SymDenotations.scala:385)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.unforcedDecls(SymDenotations.scala:409)
	dotty.tools.dotc.core.SymDenotations$ClassDenotation.typeParamsFromDecls(SymDenotations.scala:1896)
	dotty.tools.dotc.core.SymDenotations$ClassDenotation.typeParams(SymDenotations.scala:1909)
	dotty.tools.dotc.core.classfile.ClassfileParser$$anon$2.apply(ClassfileParser.scala:66)
	dotty.tools.dotc.core.classfile.ClassfileParser$$anon$2.apply(ClassfileParser.scala:65)
	scala.collection.immutable.List.mapConserve(List.scala:473)
	dotty.tools.dotc.core.classfile.ClassfileParser$$anon$2.apply(ClassfileParser.scala:75)
	dotty.tools.dotc.core.classfile.ClassfileParser$AttributeCompleter.complete(ClassfileParser.scala:928)
	dotty.tools.dotc.core.classfile.ClassfileParser.parseClass(ClassfileParser.scala:418)
	dotty.tools.dotc.core.classfile.ClassfileParser.$anonfun$1(ClassfileParser.scala:302)
	dotty.tools.dotc.core.classfile.ClassfileParser.run(ClassfileParser.scala:297)
	dotty.tools.dotc.core.ClassfileLoader.doComplete(SymbolLoaders.scala:417)
	dotty.tools.dotc.core.SymbolLoader.complete(SymbolLoaders.scala:348)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.completeFrom(SymDenotations.scala:175)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.completeOnce(SymDenotations.scala:385)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.unforcedDecls(SymDenotations.scala:409)
	dotty.tools.dotc.core.SymDenotations$ClassDenotation.typeParamsFromDecls(SymDenotations.scala:1896)
	dotty.tools.dotc.core.SymDenotations$ClassDenotation.typeParams(SymDenotations.scala:1909)
	dotty.tools.dotc.core.classfile.ClassfileParser$$anon$2.apply(ClassfileParser.scala:66)
	dotty.tools.dotc.core.classfile.ClassfileParser$$anon$2.apply(ClassfileParser.scala:65)
	scala.collection.immutable.List.mapConserve(List.scala:473)
	dotty.tools.dotc.core.classfile.ClassfileParser$$anon$2.apply(ClassfileParser.scala:75)
	dotty.tools.dotc.core.classfile.ClassfileParser$AttributeCompleter.complete(ClassfileParser.scala:928)
	dotty.tools.dotc.core.classfile.ClassfileParser.parseClass(ClassfileParser.scala:418)
	dotty.tools.dotc.core.classfile.ClassfileParser.$anonfun$1(ClassfileParser.scala:302)
	dotty.tools.dotc.core.classfile.ClassfileParser.run(ClassfileParser.scala:297)
	dotty.tools.dotc.core.ClassfileLoader.doComplete(SymbolLoaders.scala:417)
	dotty.tools.dotc.core.SymbolLoader.complete(SymbolLoaders.scala:348)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.completeFrom(SymDenotations.scala:175)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.completeOnce(SymDenotations.scala:385)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.unforcedDecls(SymDenotations.scala:409)
	dotty.tools.dotc.core.SymDenotations$ClassDenotation.typeParamsFromDecls(SymDenotations.scala:1896)
	dotty.tools.dotc.core.SymDenotations$ClassDenotation.typeParams(SymDenotations.scala:1909)
	dotty.tools.dotc.core.unpickleScala2.Scala2Unpickler.readType(Scala2Unpickler.scala:854)
	dotty.tools.dotc.core.unpickleScala2.Scala2Unpickler$LocalUnpickler.$anonfun$6(Scala2Unpickler.scala:620)
	dotty.tools.dotc.core.unpickleScala2.Scala2Unpickler.atReadPos(Scala2Unpickler.scala:316)
	dotty.tools.dotc.core.unpickleScala2.Scala2Unpickler.at(Scala2Unpickler.scala:306)
	dotty.tools.dotc.core.unpickleScala2.Scala2Unpickler$LocalUnpickler.parseToCompletion$1(Scala2Unpickler.scala:620)
	dotty.tools.dotc.core.unpickleScala2.Scala2Unpickler$LocalUnpickler.complete$$anonfun$1(Scala2Unpickler.scala:667)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	dotty.tools.dotc.core.unpickleScala2.Scala2Unpickler.atReadPos(Scala2Unpickler.scala:316)
	dotty.tools.dotc.core.unpickleScala2.Scala2Unpickler$LocalUnpickler.complete(Scala2Unpickler.scala:665)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.completeFrom(SymDenotations.scala:175)
	dotty.tools.dotc.core.Denotations$Denotation.completeInfo$1(Denotations.scala:190)
	dotty.tools.dotc.core.Denotations$Denotation.info(Denotations.scala:192)
	dotty.tools.dotc.core.SymDenotations$LazyType.completerTypeParams(SymDenotations.scala:2767)
	dotty.tools.dotc.core.TypeApplications$.typeParams$extension(TypeApplications.scala:186)
	dotty.tools.dotc.core.TypeApplications$.typeParamSymbols$extension(TypeApplications.scala:230)
	dotty.tools.dotc.typer.Typer.adaptType$1(Typer.scala:4550)
	dotty.tools.dotc.typer.Typer.adapt1(Typer.scala:4659)
	dotty.tools.dotc.typer.Typer.adapt(Typer.scala:3932)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3554)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3558)
	dotty.tools.dotc.typer.Typer.typedType(Typer.scala:3672)
	dotty.tools.dotc.typer.Namer.typedAheadType$$anonfun$1(Namer.scala:1744)
	dotty.tools.dotc.typer.Namer.typedAhead(Namer.scala:1737)
	dotty.tools.dotc.typer.Namer.typedAheadType(Namer.scala:1744)
	dotty.tools.dotc.typer.Applications.realApply$1(Applications.scala:1027)
	dotty.tools.dotc.typer.Applications.typedApply(Applications.scala:1231)
	dotty.tools.dotc.typer.Applications.typedApply$(Applications.scala:434)
	dotty.tools.dotc.typer.Typer.typedApply(Typer.scala:145)
	dotty.tools.dotc.typer.Typer.typedUnnamed$1(Typer.scala:3392)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3477)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3554)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3558)
	dotty.tools.dotc.typer.Typer.typedThrow(Typer.scala:2287)
	dotty.tools.dotc.typer.Typer.typedUnnamed$1(Typer.scala:3411)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3477)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3554)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3558)
	dotty.tools.dotc.typer.Typer.typedIf(Typer.scala:1473)
	dotty.tools.dotc.typer.Typer.typedUnnamed$1(Typer.scala:3401)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3477)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3554)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3558)
	dotty.tools.dotc.typer.Typer.traverse$1(Typer.scala:3607)
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

java.lang.AssertionError: assertion failed: denotation module class Throwable$ invalid in run 3. ValidFor: Period(4.1-2)