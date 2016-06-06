package com.vladsch.flexmark.ext.autolink;

import com.vladsch.flexmark.Extension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.node.Node;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.test.FullSpecTestCase;

import java.util.Collections;
import java.util.Set;

public class AutolinkFullSpecTest extends FullSpecTestCase {
    static final String SPEC_RESOURCE = "/ext_autolink_ast_spec.txt";
    private static final Set<Extension> EXTENSIONS = Collections.singleton(AutolinkExtension.create());
    static final HtmlRenderer RENDERER = HtmlRenderer.builder().extensions(EXTENSIONS).build();
    static final Parser PARSER = Parser.builder().extensions(EXTENSIONS).build();

    @Override
    protected String getSpecResourceName() {
        return SPEC_RESOURCE;
    }

    @Override
    protected Node parse(String source) {
        return PARSER.parse(source);
    }

    @Override
    protected String render(Node node) {
        return RENDERER.render(node);
    }
}
