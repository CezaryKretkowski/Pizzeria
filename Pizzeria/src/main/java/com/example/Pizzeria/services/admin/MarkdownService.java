package com.example.Pizzeria.services.admin;

import com.example.Pizzeria.repositories.StaticFileRepository;
import lombok.AllArgsConstructor;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MarkdownService {
    private final StaticFileRepository staticFileRepository;
    public String getHtmlCode(String fileName){
        String markdown = staticFileRepository.readStaticFiles(fileName);
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        return HtmlRenderer.builder().build().render(document);
    }

    public String getMarkDownCode(String fileName){
        return staticFileRepository.readStaticFiles(fileName);
    }

    public void saveCode(String content){staticFileRepository.saveFile(content);}
}
