#!/usr/bin/env python
# Eclipse SUMO, Simulation of Urban MObility; see https://eclipse.org/sumo
# Copyright (C) 2009-2018 German Aerospace Center (DLR) and others.
# This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v2.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v20.html
# SPDX-License-Identifier: EPL-2.0

# @file    test.py
# @author  Pablo Alvarez Lopez
# @date    2016-11-25
# @version $Id$

# import common functions for netedit tests
import os
import sys

testRoot = os.path.join(os.environ.get('SUMO_HOME', '.'), 'tests')
neteditTestRoot = os.path.join(
    os.environ.get('TEXTTEST_HOME', testRoot), 'netedit')
sys.path.append(neteditTestRoot)
import neteditTestFunctions as netedit  # noqa

# Open netedit
neteditProcess, match = netedit.setupAndStart(neteditTestRoot)

# first rebuild network
netedit.rebuildNetwork()

# go to select mode
netedit.selectMode()

# show connections
netedit.toogleShowConnections()

# use a rectangle to check add mode
netedit.selectionRectangle(match, 50, 50, 500, 400)

# clear selection
netedit.selectionClear()

# lock junctions
netedit.lockSelection(1)

# use a rectangle to check add mode
netedit.selectionRectangle(match, 50, 50, 500, 400)

# clear selection
netedit.selectionClear()

# lock edges
netedit.lockSelection(2)

# use a rectangle to check add mode
netedit.selectionRectangle(match, 50, 50, 500, 400)

# clear selection
netedit.selectionClear()

# toogle lanes
netedit.toogleSelectEdges()

# use a rectangle to check add mode
netedit.selectionRectangle(match, 50, 50, 500, 400)

# clear selection
netedit.selectionClear()

# lock lanes
netedit.lockSelection(3)

# use a rectangle to check add mode
netedit.selectionRectangle(match, 50, 50, 500, 400)

# clear selection
netedit.selectionClear()

# lock connections
netedit.lockSelection(4)

# use a rectangle to check add mode
netedit.selectionRectangle(match, 50, 50, 500, 400)

# clear selection
netedit.selectionClear()

# lock additionals
netedit.lockSelection(5)

# use a rectangle to check add mode
netedit.selectionRectangle(match, 50, 50, 500, 400)

# clear selection
netedit.selectionClear()

# lock crossings
netedit.lockSelection(6)

# use a rectangle to check add mode
netedit.selectionRectangle(match, 50, 50, 500, 400)

# clear selection
netedit.selectionClear()

# lock polygons
netedit.lockSelection(7)

# use a rectangle to check add mode
netedit.selectionRectangle(match, 50, 50, 500, 400)

# clear selection
netedit.selectionClear()

# lock POI
netedit.lockSelection(8)

# use a rectangle to check add mode
netedit.selectionRectangle(match, 50, 50, 500, 400)

# clear selection
netedit.selectionClear()

# check undo and redo
netedit.undo(match, 18)
netedit.redo(match, 18)

# save additionals
netedit.saveAdditionals()

# save shapes
netedit.saveShapes()

# save network
netedit.saveNetwork()

# quit netedit
netedit.quit(neteditProcess)


