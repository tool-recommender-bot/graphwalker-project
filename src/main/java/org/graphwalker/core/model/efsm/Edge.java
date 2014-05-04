package org.graphwalker.core.model.efsm;

/*
 * #%L
 * GraphWalker Core
 * %%
 * Copyright (C) 2011 - 2014 GraphWalker
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import org.graphwalker.core.model.Builder;
import org.graphwalker.core.model.NamedElement;

/**
 * @author Nils Olsson
 */
public final class Edge extends NamedElement {

    private final Vertex sourceVertex;
    private final Vertex targetVertex;

    private Edge(EdgeBuilder builder) {
        super(builder.getName());
        this.sourceVertex = builder.getSourceVertex().build();
        this.targetVertex = builder.getTargetVertex().build();
    }

    public Vertex getSourceVertex() {
        return sourceVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public static class EdgeBuilder implements Builder<Edge> {

        private String name;
        private Builder<Vertex> sourceVertex;
        private Builder<Vertex> targetVertex;

        public EdgeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public String getName() {
            return name;
        }

        public EdgeBuilder setSourceVertex(Builder<Vertex> vertex) {
            this.sourceVertex = vertex;
            return this;
        }

        public Builder<Vertex> getSourceVertex() {
            return sourceVertex;
        }

        public EdgeBuilder setTargetVertex(Builder<Vertex> vertex) {
            this.targetVertex = vertex;
            return this;
        }

        public Builder<Vertex> getTargetVertex() {
            return targetVertex;
        }

        @Override
        public Edge build() {
            return new Edge(this);
        }
    }
}
