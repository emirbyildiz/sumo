/****************************************************************************/
// Eclipse SUMO, Simulation of Urban MObility; see https://eclipse.org/sumo
// Copyright (C) 2016-2018 German Aerospace Center (DLR) and others.
// This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v2.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v20.html
// SPDX-License-Identifier: EPL-2.0
/****************************************************************************/
/// @file    SumoDetectors.java
/// @author  Maximiliano Bottazzi
/// @date    2016
/// @version $Id$
///
//
/****************************************************************************/
package de.dlr.ts.lisum.sumo;

import de.dlr.ts.commons.logger.DLRLogger;
import de.dlr.ts.lisum.interfaces.DetectorInterface;
import de.dlr.ts.utils.xmladmin2.XMLAdmin2;
import de.dlr.ts.utils.xmladmin2.exceptions.MalformedKeyOrNameException;
import de.dlr.ts.utils.xmladmin2.exceptions.XMLNodeNotFoundException;
import it.polito.appeal.traci.InductionLoop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.SAXException;

/**
 *
 * @author @author <a href="mailto:maximiliano.bottazzi@dlr.de">Maximiliano Bottazzi</a>
 */
class SumoDetectors
{
    private final List<SumoDetector> detectors = new ArrayList<>();    

    
    /**
     * 
     */
    public SumoDetectors(/*VehicleTypes vehicleTypes*/)
    {
        //this.vehicleTypes = vehicleTypes;
    }
    
    /**
     * 
     */
    public void executeSimulationStep()
    {
        for (SumoDetector detector : detectors)
            detector.executeSimulationStep();
    }
    
    /**
     * 
     * @param name 
     */
    public void addDetector(String name, InductionLoop induct, DetectorInterface cityDetector)
    {
        SumoDetector sd = new SumoDetector(name /*, vehicleTypes*/);
        sd.setSumoInductionLoop(induct);
        sd.setCityDetector(cityDetector);
        
        detectors.add(sd);
        
        DLRLogger.info(this, "Adding detector " + sd);
    }
    
    /**
     * 
     * @param file 
     */
    public void load(File sumoAddFile)
    {
        if(sumoAddFile == null)
            return;
        
        try
        {
            XMLAdmin2 x = new XMLAdmin2().load(sumoAddFile);
            int nodesCount = x.getNodesCount("inductionLoop");
            
            for (int i = 0; i < nodesCount; i++)
            {
                String name = x.getNode("inductionLoop", i).getAttributes().get("id").getValue();
                //String lane = x.getNode("inductionLoop", i).getAttributes().get("lane").getValue();
                //String pos = x.getNode("inductionLoop", i).getAttributes().get("pos").getValue();
                
                SumoDetector sd = new SumoDetector(name /*, vehicleTypes*/);
                detectors.add(sd);
                
                DLRLogger.info(this, "Adding detector " + sd);
            }
        }
        catch (MalformedKeyOrNameException | XMLNodeNotFoundException | SAXException | IOException ex)
        {
            ex.printStackTrace(System.out);
        }
    }
    
    /**
     * 
     * @param index
     * @return 
     */
    public SumoDetector getSumoDetector(int index)
    {
        return detectors.get(index);
    }
    
    /**
     *      
     * @return 
     */
    public SumoDetector getSumoDetector(String name)
    {
        for (SumoDetector detector : detectors)
            if(detector.getName().equals(name))
                return detector;
        
        return null;
    }
}
