/**
 * Copyright (c) 2017 "Neo4j, Inc." <http://neo4j.com>
 *
 * This file is part of Neo4j Graph Algorithms <http://github.com/neo4j-contrib/neo4j-graph-algorithms>.
 *
 * Neo4j Graph Algorithms is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.graphalgo.algo;

import org.junit.*;
import org.neo4j.graphalgo.KSpanningTreeProc;
import org.neo4j.graphalgo.TestDatabaseCreator;
import org.neo4j.graphalgo.TriangleProc;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Transaction;
import org.neo4j.kernel.api.exceptions.KernelException;
import org.neo4j.kernel.impl.proc.Procedures;
import org.neo4j.kernel.internal.GraphDatabaseAPI;
import org.neo4j.test.rule.ImpermanentDatabaseRule;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 *
 * @author mknblch
 */
public class TriangleStreamTest_451 {

    @ClassRule
    public static ImpermanentDatabaseRule DB = new ImpermanentDatabaseRule();

    @BeforeClass
    public static void setup() throws KernelException {
        DB.resolveDependency(Procedures.class).registerProcedure(TriangleProc.class);
    }


    @Test
    public void testEmptySet() throws Exception {
        DB.execute("CALL algo.triangleCount.stream('Foo', 'Bar') YIELD nodeId, triangles");

    }

}
