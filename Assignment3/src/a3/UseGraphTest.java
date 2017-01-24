package a3;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;

import a3.Graph;
import a3.GraphIsFullException;
import a3.UseGraph;
import a3.VertexExistsException;

public class UseGraphTest {

	// Reflection tests

	@Test(timeout=100)
	//@Description(description = "The loadGraph() method")
	public void testReflectionMethodLoadGraph() {
		try {
			Class<?> c = UseGraph.class;
			Method m = c.getDeclaredMethod("loadGraph", new Class<?>[]{String.class});
			Type t = m.getReturnType();
			assertTrue("The return type of loadGraph() should be Graph<String>", 
					t.equals(Graph.class));
		} catch(NoSuchMethodException e) {
			fail("The loadGraph() method is either private or could not be found");
		}
	}

	// Functionality tests

		@Test(timeout=100)
		//@Description(description = "Functionality tests:0")
		public void testLoadGraph1() {
			try {
				String[] arg = new String[1];
				arg[0] = "g1.txt";

				PrintStream originalOut = System.out;         
				OutputStream os = new ByteArrayOutputStream(); 
				PrintStream ps = new PrintStream(os); 
				System.setOut(ps); 
				UseGraph.main(arg);	

				String expected = "[[A, B], [C]]";
						
				assertEquals("The program did not output the expected result",expected.toString().replaceAll("\\s","").replaceAll("\\n",""), os.toString().replaceAll("\\s","").replaceAll("\\n",""));
				System.setOut(originalOut);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (GraphIsFullException e) {
				e.printStackTrace();
			} catch (VertexExistsException e) {
				e.printStackTrace();
			}
		}
		
		@Test(timeout=100)
		//@Description(description = "Functionality tests:1")
		public void testLoadGraph2() {
			try {
				String[] arg = new String[1];
				arg[0] = "g2.txt";

				PrintStream originalOut = System.out;         
				OutputStream os = new ByteArrayOutputStream(); 
				PrintStream ps = new PrintStream(os); 
				System.setOut(ps); 
				UseGraph.main(arg);

				String expected = "[[A, B, C, D]]";

				assertEquals("The program did not output the expected result",expected.toString().replaceAll("\\s","").replaceAll("\\n",""), os.toString().replaceAll("\\s","").replaceAll("\\n",""));
				System.setOut(originalOut);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (GraphIsFullException e) {
				e.printStackTrace();
			} catch (VertexExistsException e) {
				e.printStackTrace();
			}


		}
		
		@Test(timeout=100)
		//@Description(description = "Functionality tests:2")
		public void testLoadGraph3() {
			try {
				String[] arg = new String[1];
				arg[0] = "g3.txt";

				PrintStream originalOut = System.out;         
				OutputStream os = new ByteArrayOutputStream(); 
				PrintStream ps = new PrintStream(os); 
				System.setOut(ps); 
				UseGraph.main(arg);

				String expected = "[[1, 2, 3, 5, 6, 7], [4, 8]]";
				
				assertEquals("The program did not output the expected result",expected.toString().replaceAll("\\s","").replaceAll("\\n",""), os.toString().replaceAll("\\s","").replaceAll("\\n",""));
				System.setOut(originalOut);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (GraphIsFullException e) {
				e.printStackTrace();
			} catch (VertexExistsException e) {
				e.printStackTrace();
			}


		}
		
		@Test(timeout=100)
		//@Description(description = "Functionality tests:3")
		public void testLoadGraph4() {
			try {
				String[] arg = new String[1];
				arg[0] = "g4.txt";

				PrintStream originalOut = System.out;         
				OutputStream os = new ByteArrayOutputStream(); 
				PrintStream ps = new PrintStream(os); 
				System.setOut(ps); 
				UseGraph.main(arg);

				String expected = "[[A, B, C, D, E, F, G], [H], [I, J]]";		

				assertEquals("The program did not output the expected result",expected.toString().replaceAll("\\s","").replaceAll("\\n",""), os.toString().replaceAll("\\s","").replaceAll("\\n",""));
				System.setOut(originalOut);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (GraphIsFullException e) {
				e.printStackTrace();
			} catch (VertexExistsException e) {
				e.printStackTrace();
			}


		}
		
		@Test(timeout=100)
		//@Description(description = "Functionality tests:4")
		public void testLoadGraph5() {
			try {
				String[] arg = new String[1];
				arg[0] = "g5.txt";

				PrintStream originalOut = System.out;         
				OutputStream os = new ByteArrayOutputStream(); 
				PrintStream ps = new PrintStream(os); 
				System.setOut(ps); 
				UseGraph.main(arg);	

				String expected = "[[A, B, C, D], [E, F, G, H, I], [J, K], [L]]";
				assertEquals("The program did not output the expected result",expected.toString().replaceAll("\\s","").replaceAll("\\n",""), os.toString().replaceAll("\\s","").replaceAll("\\n",""));
				System.setOut(originalOut);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (GraphIsFullException e) {
				e.printStackTrace();
			} catch (VertexExistsException e) {
				e.printStackTrace();
			}


		}

		static boolean equalArrayLists(ArrayList<Set<String>> A1, ArrayList<Set<String>> A2){
			if(A1.size() != A2.size()) { return false; }
			for (Set<String> e : A1)
			{
				if (!A2.contains(e))
				{
					return false;
				}
			}
			return true;
		}


	}