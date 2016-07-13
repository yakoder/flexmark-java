package com.vladsch.flexmark.ext.spec.example;

import com.vladsch.flexmark.Extension;
import com.vladsch.flexmark.ext.spec.example.internal.SpecExampleBlockParser;
import com.vladsch.flexmark.ext.spec.example.internal.SpecExampleNodeRenderer;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.internal.util.options.DataKey;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.spec.SpecReader;

/**
 * Extension for spec_examples
 * <p>
 * Create it with {@link #create()} and then configure it on the builders
 * ({@link com.vladsch.flexmark.parser.Parser.Builder#extensions(Iterable)},
 * {@link com.vladsch.flexmark.html.HtmlRenderer.Builder#extensions(Iterable)}).
 * </p>
 * <p>
 * The parsed spec_example text is turned into {@link com.vladsch.flexmark.spec.SpecExample} nodes.
 * </p>
 */
public class SpecExampleExtension implements Parser.ParserExtension, HtmlRenderer.HtmlRendererExtension {
    // final public static DataKey<SpecExampleRepository> SPEC_EXAMPLES = new DataKey<>("SPEC_EXAMPLES", SpecExampleRepository::new); 
    // final public static DataKey<KeepType> SPEC_EXAMPLES_KEEP = new DataKey<>("SPEC_EXAMPLES_KEEP", KeepType.FIRST); // standard option to allow control over how to handle duplicates 
    final public static DataKey<Boolean> SPEC_EXAMPLE_RENDER_HTML = new DataKey<>("SPEC_EXAMPLE_RENDER_HTML", true); 
    final public static DataKey<String> SPEC_EXAMPLE_BREAK = new DataKey<>("SPEC_EXAMPLE_BREAK", SpecReader.EXAMPLE_BREAK); 
    final public static DataKey<String> SPEC_TYPE_BREAK = new DataKey<>("SPEC_TYPE_BREAK", SpecReader.TYPE_BREAK); 

    private SpecExampleExtension() {
    }

    public static Extension create() {
        return new SpecExampleExtension();
    }

    @Override
    public void extend(Parser.Builder parserBuilder) {
        parserBuilder.customBlockParserFactory(new SpecExampleBlockParser.Factory());
    }

    @Override
    public void extend(HtmlRenderer.Builder rendererBuilder) {
        rendererBuilder.nodeRendererFactory(SpecExampleNodeRenderer::new);
    }
}
