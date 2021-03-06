# Revision History

## 3.0.1-SNAPSHOT
* Next dev release.
 
## 3.0
* New RDF->OXL converter added.
* More types from Knetminer added to the Ondex metadata file
* DOT rendering added to the semantic motif state machine package. We use it in the [Cypher traverser component][3.0-10], 
to generate [Knetminer views of searched motifs][3.0-20].
* Various bugfixes in the components:
  * Neo4j-export
  * OWL-parser
  * Lucene adapter (in particular, exact searches of accessions fixed, impact on component like the concept mapper)
* Internal changes:
  * Maven artifactory migrated to [our new Nexus](https://knetminer.org/artifactory/).
  * Maven POM linked to [our common POM][3.0-30].
  * Cleaning and improvement of both code and Maven files.
  * In-memory URI-based index component (used for the Cypher Traverser).
  * Abstracting the semantic motif traverser, and [Cypher-based traverser created as an extension][3.0-10].

[3.0-10]: https://github.com/Rothamsted/knetminer-backend
[3.0-20]: https://github.com/Rothamsted/knetminer/tree/master/species
[3.0-30]: https://github.com/Rothamsted/knetminer-common

## 2.1
* Improvements to OWL/Ondex mappings ([example](https://github.com/Rothamsted/ondex-knet-builder/commit/eff609d09550cc96f2ed877a91b45764aa6528e6)). 
* Minor changes to the launching scripts ([example](https://github.com/Rothamsted/ondex-desktop/commit/0b2f5145207fb21553b682c78f81752b553eed09)).
* Fixing problems with OXL Import/Export ([#12](https://github.com/Rothamsted/ondex-knet-builder/issues/12), [#14](https://github.com/Rothamsted/ondex-knet-builder/issues/14)).
* Fixing issues with the FASTA parser ([1](https://github.com/Rothamsted/ondex-knet-builder/commit/3795afd8c10c3000bbc6f443dd0b33b5cd309f5a), [2](https://github.com/Rothamsted/ondex-knet-builder/commit/dbea4cd20bbbcfe2140a284c187d5fd4b66a5add)).
* Internal changes:  
  * Improvements in the parser API ([1](https://github.com/Rothamsted/ondex-base/commit/4e3d238111a3367c7531b4815c0a777b1261ed6f), [2](https://github.com/Rothamsted/ondex-base/commit/7b3406761162ef0aa44f2706a349f341d3d8a9a1), [3](https://github.com/Rothamsted/ondex-base/commit/ff79d961a4f0fcf5c3a15d8ec7be99e694660419)).  
  * Minor review of the common type definitions (see [ondex_metadata.xml](https://github.com/Rothamsted/ondex-base/blob/master/datadir/src/main/resources/xml/ondex_metadata.xml)).  
  * Minor fixes to fasta-gff3 Parser and JSON Export plugins
  * Minor [review of some logging messages](https://github.com/Rothamsted/ondex-base/commit/38238b3fb0460a7d2e8417610b03309dfa5dfa74).  
  

## 2.0
* Graph Databases and Linked Data support:
  * [New RDF Exporter](modules/rdf-export-2) plug-in.
  * [Tool to export ONDEX RDF to Neo4j](modules/neo4j-export).
* OWL Parser and base components for developers:
  * Complete review of the [generic parser](https://github.com/Rothamsted/ondex-base/tree/master/core/parser-api) architecture, 
      which now has clear separation between [data source decomposition](https://github.com/Rothamsted/ondex-base/blob/master/core/parser-api/src/main/java/net/sourceforge/ondex/parser/Scanner.java) 
      and [mapping](https://github.com/Rothamsted/ondex-base/blob/master/core/parser-api/src/main/java/net/sourceforge/ondex/parser/Mapper.java). 
  * The [OWL Parser](https://github.com/Rothamsted/ondex-knet-builder/tree/master/modules/owl-parser/src/main/java/net/sourceforge/ondex/parser/owl) 
      was changed accordingly.
  * Generic packages (ie, the generic parser library and a few [utilities](https://github.com/Rothamsted/ondex-base/tree/master/core/base/src/main/java/net/sourceforge/ondex/core/util))
      were migrated from the owl parser module to proper places.
  * Several mappings for common ontologies added.
* All ONDEX code reviewed and migrated to Lucene 6.0.0.  
* Berkeley support removed from the main build.
* Bugfixing and Enhancements:  
  	 * Text mining module (to support new PubMed XML, [#12](https://github.com/Rothamsted/ondex-knet-builder/issues/12), [#13](https://github.com/Rothamsted/ondex-knet-builder/issues/12)).
  	 * New Concept Classes and and relation types added.


## 1.2
* OWL parser
  * Some debugging and improvements in parsing GO, TO, FYPO ontologies
  * Options to customise accession prefixes in the final ONDEX graph
* UniProt parser
  * GO terms added from accessions file [itself](https://github.com/Rothamsted/ondex-knet-builder/commit/b07c6469c7631a82bce65a46226abcaa0d3a2a00)
  * obo file [excluded](https://github.com/Rothamsted/ondex-knet-builder/commit/6c383b8d2be4455be0c132b1065947af40c715e0)
* Graph-merge options [added to the tab-parser-2](https://github.com/Rothamsted/ondex-knet-builder/commit/c0d907b099999635ecf577f32fec9fb8e0310e48) to the tabular parser
