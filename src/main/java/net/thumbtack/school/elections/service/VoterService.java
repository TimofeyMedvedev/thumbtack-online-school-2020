package net.thumbtack.school.elections.service;

import com.google.gson.Gson;
import net.thumbtack.school.elections.dao.VoterDao;
import net.thumbtack.school.elections.daoimpl.VoterDaoImpl;
import net.thumbtack.school.elections.database.DatabaseException;
import net.thumbtack.school.elections.dto.request.RegisterVoterDtoRequest;
import net.thumbtack.school.elections.dto.request.RegisterVoterDtoRequestException;
import net.thumbtack.school.elections.dto.response.RegisterVoterDtoResponse;
import net.thumbtack.school.elections.model.Voter;

public class VoterService {
    private static Gson gson = new Gson();
    private static VoterDao voterDao;

    public String registerVoter(String requestJsonString) {
        RegisterVoterDtoRequest registerVoterDtoRequest = gson.fromJson(requestJsonString, RegisterVoterDtoRequest.class);

        try {
            registerVoterDtoRequest.validate();
            // REVU: не нужно делать настолько гранулированные исключения. вообще можно сделать только одно исключение
            // для всего приложения
        } catch (RegisterVoterDtoRequestException e) {
            // REVU: создайте специальный класс для ошибок - ErrorResponse с одним полем - описанием ошибки. создайте
            // объект этого класса здесь, а затем верните его в формате json
            return new Gson().toJson(e);
        }

        // REVU: сделайте VoterDao полем класса
        voterDao = new VoterDaoImpl();

        try {
            voterDao.insert(new Voter(registerVoterDtoRequest));
        } catch (DatabaseException e) {
            return new Gson().toJson(e);
        }

        RegisterVoterDtoResponse registerVoterDtoResponse = new RegisterVoterDtoResponse();
        // REVU: вот это не очень понятно. токен должен присваиваться сессии и храниться в базе данных, а Вы его сейчас
        // просто так создаете, для галочки, безо всякой полезной нагрузки. и вообще нужно вернуть объект класса
        // RegisterVoterDtoResponse в формате json
        return new Gson().toJson(registerVoterDtoResponse.getToken());
    }
}
