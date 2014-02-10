JXX=javac

chap1 = 
chap2 =
chap3 = 
chap4 = TreeNode.class	  \
	Tree.class	  \
	IntWrapper.class  \
	isBalanced.class  \
	minBST.class	  \
	getLevels.class	  \
	isBST.class	  \
	Successor.class	  \
	inOrderSuccessor.class \
	commonParent.class	\
	isSubTree.class	  \
	FindPathSum.class \


all:$(chap1) $(chap2) $(chap3) $(chap4)

$(chap4) : %.class: chap4/%.java
	javac $<

clean:
	rm -fr *.class chap1/*.class chap2/*.class chap3/*.class chap4/*.class chap5/*.class
