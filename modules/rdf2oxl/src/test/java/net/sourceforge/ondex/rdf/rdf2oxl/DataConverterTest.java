package net.sourceforge.ondex.rdf.rdf2oxl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.io.Resources;

import net.sourceforge.ondex.rdf.rdf2oxl.support.ItemConfiguration;
import net.sourceforge.ondex.rdf.rdf2oxl.support.Rdf2OxlConfiguration;
import uk.ac.ebi.utils.xml.XPathReader;

/**
 * TODO: comment me!
 *
 * @author brandizi
 * <dl><dt>Date:</dt><dd>1 Aug 2018</dd></dl>
 *
 */
public class DataConverterTest extends AbstractConverterTest
{
	@BeforeClass
	public static void initData () throws IOException
	{
		resultOxl = generateOxl (
			"target/concepts_test.oxl", 
			"target/concepts_test_tdb",
			Pair.of ( Resources.getResource ( "bioknet.owl" ).openStream (), "RDF/XML" ),
			Pair.of ( Resources.getResource ( "oxl_templates_test/bk_ondex.owl" ).openStream (), "RDF/XML" ),
			Pair.of ( Resources.getResource ( "support_test/publications.ttl" ).openStream (), "TURTLE" )
		);
	}
	
	@Test
	public void testConcepts () throws IOException
	{
		final String oxlPrefix = "/ondex/ondexdataseq/concepts";

		XPathReader xpath = new XPathReader ( resultOxl );
		assertEquals ( "Concept PMID:26396590 not found or too many of them!", 
			1,
			xpath.readNodeList ( oxlPrefix + "/concept[pid = '26396590']" ).getLength ()
		);		
	}
	
	
	/**
	 * Just a test to move {@link Rdf2OxlConfiguration} to the XML, which should have a simpler syntax.
	 */
	@Test
	public void testBean ()
	{
		ItemConfiguration icfg = springContext.getBean ( "testConfig", ItemConfiguration.class );
		System.out.println ( icfg.getHeader () );
	}
}
