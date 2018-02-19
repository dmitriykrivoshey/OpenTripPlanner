/* This program is free software: you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public License
as published by the Free Software Foundation, either version 3 of
the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>. */

package org.opentripplanner.updater.transportation_network_company;

import com.fasterxml.jackson.databind.JsonNode;
import org.opentripplanner.routing.graph.Graph;
import org.opentripplanner.updater.GraphUpdater;
import org.opentripplanner.updater.GraphUpdaterManager;

public class TransportationNetworkCompanyUpdater implements GraphUpdater {

    private GraphUpdaterManager updaterManager;
    private TransportationNetworkCompanyDataSource source;

    @Override
    public void setGraphUpdaterManager(GraphUpdaterManager updaterManager) {
        this.updaterManager = updaterManager;
    }

    @Override
    public void setup() throws Exception {
        // Not sure what would be needed here
    }

    @Override
    public void run() throws Exception {

    }

    @Override
    public void teardown() { }

    @Override
    public void configure(Graph graph, JsonNode config) throws Exception {
        // Set data source type from config JSON
        String sourceType = config.path("sourceType").asText();
        if (sourceType != null) {
            if (sourceType.equals("uber")) {
                source = new UberTransportationNetworkCompanyDataSource(config.path("serverToken").asText());
            }
        }
    }
}