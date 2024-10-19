file:///C:/Users/wergh/cryptage_scala/Algo.scala
### java.lang.AssertionError: assertion failed: denotation class Int invalid in run 3. ValidFor: Period(4.1-2)

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 611
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
    while (m < pairs.length && n @@< pairs.length) {
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
	dotty.tools.dotc.core.Symbols$.toDenot(Symbols.scala:544)
	dotty.tools.dotc.core.ConstraintHandling.widenInferred(ConstraintHandling.scala:679)
	dotty.tools.dotc.core.ConstraintHandling.widenInferred$(ConstraintHandling.scala:29)
	dotty.tools.dotc.core.TypeComparer.widenInferred(TypeComparer.scala:30)
	dotty.tools.dotc.core.ConstraintHandling.instanceType(ConstraintHandling.scala:715)
	dotty.tools.dotc.core.ConstraintHandling.instanceType$(ConstraintHandling.scala:29)
	dotty.tools.dotc.core.TypeComparer.instanceType(TypeComparer.scala:30)
	dotty.tools.dotc.core.TypeComparer$.instanceType(TypeComparer.scala:3254)
	dotty.tools.dotc.core.Types$TypeVar.typeToInstantiateWith(Types.scala:5033)
	dotty.tools.dotc.core.Types$TypeVar.instantiate(Types.scala:5043)
	dotty.tools.dotc.typer.Inferencing.tryInstantiate$1(Inferencing.scala:790)
	dotty.tools.dotc.typer.Inferencing.doInstantiate$1(Inferencing.scala:793)
	dotty.tools.dotc.typer.Inferencing.interpolateTypeVars(Inferencing.scala:796)
	dotty.tools.dotc.typer.Inferencing.interpolateTypeVars$(Inferencing.scala:611)
	dotty.tools.dotc.typer.Typer.interpolateTypeVars(Typer.scala:145)
	dotty.tools.dotc.typer.Typer.simplify(Typer.scala:3495)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3480)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3554)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3558)
	dotty.tools.dotc.typer.Typer.typedAssign(Typer.scala:1353)
	dotty.tools.dotc.typer.Typer.typedUnnamed$1(Typer.scala:3399)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3477)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3554)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3558)
	dotty.tools.dotc.typer.Typer.typedIf(Typer.scala:1473)
	dotty.tools.dotc.typer.Typer.typedUnnamed$1(Typer.scala:3401)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3477)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3554)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3558)
	dotty.tools.dotc.typer.Typer.typedExpr(Typer.scala:3669)
	dotty.tools.dotc.typer.Typer.typedBlock(Typer.scala:1384)
	dotty.tools.dotc.typer.Typer.typedUnnamed$1(Typer.scala:3400)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3477)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3554)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3558)
	dotty.tools.dotc.typer.Typer.typedExpr(Typer.scala:3669)
	dotty.tools.dotc.typer.Namer.typedAheadExpr$$anonfun$1(Namer.scala:1747)
	dotty.tools.dotc.typer.Namer.typedAhead(Namer.scala:1737)
	dotty.tools.dotc.typer.Namer.typedAheadExpr(Namer.scala:1747)
	dotty.tools.dotc.typer.Namer.valOrDefDefSig(Namer.scala:1803)
	dotty.tools.dotc.typer.Namer.defDefSig(Namer.scala:1959)
	dotty.tools.dotc.typer.Namer$Completer.typeSig(Namer.scala:827)
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
	dotty.tools.dotc.typer.Typer.typedFunctionValue(Typer.scala:1861)
	dotty.tools.dotc.typer.Typer.typedFunction(Typer.scala:1600)
	dotty.tools.dotc.typer.Typer.typedUnnamed$1(Typer.scala:3402)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3477)
	dotty.tools.dotc.typer.ProtoTypes$FunProto.$anonfun$7(ProtoTypes.scala:512)
	dotty.tools.dotc.typer.ProtoTypes$FunProto.cacheTypedArg(ProtoTypes.scala:435)
	dotty.tools.dotc.typer.ProtoTypes$FunProto.typedArg(ProtoTypes.scala:513)
	dotty.tools.dotc.typer.Applications$ApplyToUntyped.typedArg(Applications.scala:996)
	dotty.tools.dotc.typer.Applications$ApplyToUntyped.typedArg(Applications.scala:996)
	dotty.tools.dotc.typer.Applications$Application.addTyped$1(Applications.scala:688)
	dotty.tools.dotc.typer.Applications$Application.matchArgs(Applications.scala:752)
	dotty.tools.dotc.typer.Applications$Application.init(Applications.scala:574)
	dotty.tools.dotc.typer.Applications$TypedApply.<init>(Applications.scala:878)
	dotty.tools.dotc.typer.Applications$ApplyToUntyped.<init>(Applications.scala:995)
	dotty.tools.dotc.typer.Applications.ApplyTo(Applications.scala:1257)
	dotty.tools.dotc.typer.Applications.ApplyTo$(Applications.scala:434)
	dotty.tools.dotc.typer.Typer.ApplyTo(Typer.scala:145)
	dotty.tools.dotc.typer.Applications.simpleApply$1(Applications.scala:1068)
	dotty.tools.dotc.typer.Applications.realApply$1$$anonfun$2(Applications.scala:1178)
	dotty.tools.dotc.typer.Typer$.tryEither(Typer.scala:118)
	dotty.tools.dotc.typer.Applications.realApply$1(Applications.scala:1193)
	dotty.tools.dotc.typer.Applications.typedApply(Applications.scala:1231)
	dotty.tools.dotc.typer.Applications.typedApply$(Applications.scala:434)
	dotty.tools.dotc.typer.Typer.typedApply(Typer.scala:145)
	dotty.tools.dotc.typer.Typer.typedUnnamed$1(Typer.scala:3392)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3477)
	dotty.tools.dotc.typer.Typer.typedUnnamed$1(Typer.scala:3443)
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
	dotty.tools.pc.HoverProvider$.hover(HoverProvider.scala:40)
	dotty.tools.pc.ScalaPresentationCompiler.hover$$anonfun$1(ScalaPresentationCompiler.scala:363)
```
#### Short summary: 

java.lang.AssertionError: assertion failed: denotation class Int invalid in run 3. ValidFor: Period(4.1-2)