package net.thumbtack.school.elections;

import net.thumbtack.school.elections.service.VoterService;

public class Server {
    private VoterService voterService;

    public void startServer(String savedDataFileName) {

    }

    public void stopServer(String saveDataFileName) {

    }

    public String registerVoter(String requestJsonString) {
        return voterService.registerVoter(requestJsonString);
    }


}
