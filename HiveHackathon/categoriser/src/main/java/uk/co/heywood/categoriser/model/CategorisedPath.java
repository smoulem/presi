package uk.co.heywood.categoriser.model;

import java.nio.file.Path;

import uk.co.heywood.categoriser.model.Category;

public record CategorisedPath(Path path, Category category, double confidence)
{
}
