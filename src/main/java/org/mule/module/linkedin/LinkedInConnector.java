package org.mule.module.linkedin;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.Parameter;
import com.google.code.linkedinapi.client.enumeration.ConnectionModificationType;
import com.google.code.linkedinapi.client.enumeration.FacetField;
import com.google.code.linkedinapi.client.enumeration.NetworkUpdateType;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.ProfileType;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.client.enumeration.SearchSortOrder;
import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.FacetType;
import com.google.code.linkedinapi.schema.Likes;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.PeopleSearch;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.UpdateComments;
import com.google.code.linkedinapi.schema.VisibilityType;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Module;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.oauth.OAuth;
import org.mule.api.annotations.oauth.OAuthAccessToken;
import org.mule.api.annotations.oauth.OAuthAccessTokenSecret;
import org.mule.api.annotations.oauth.OAuthConsumerKey;
import org.mule.api.annotations.oauth.OAuthConsumerSecret;
import org.mule.api.annotations.oauth.RequiresAccessToken;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Module(name = "linkedin")
@OAuth(requestTokenUrl = "https://api.linkedin.com/uas/oauth/requestToken",
        accessTokenUrl = "https://api.linkedin.com/uas/oauth/accessToken",
        authorizationUrl = "https://api.linkedin.com/uas/oauth/authorize")
public class LinkedInConnector {

    @Configurable
    @OAuthConsumerKey
    private String apiKey;
    @Configurable
    @OAuthConsumerSecret
    private String apiSecret;

    @OAuthAccessToken
    private String accessToken;

    @OAuthAccessTokenSecret
    private String accessTokenSecret;

    private LinkedInApiClient client;

    /**
     * Gets the profile by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     *
     * @param id            the id
     * @param profileFields the profile fields
     * @return the profile by id
     */
    @Processor
    @RequiresAccessToken
    public Person getProfileById(String id, @Optional List<ProfileField> profileFields) {
        if (profileFields == null) {
            return getClient().getProfileById(id);
        } else {
            return getClient().getProfileById(id, createSet(profileFields));
        }
    }

    /**
     * Gets the profile by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     *
     * @param url           the url
     * @param profileType   the profile type
     * @param profileFields
     * @return the profile by url
     */
    @Processor
    @RequiresAccessToken
    public Person getProfileByUrl(String url, ProfileType profileType, @Optional List<ProfileField> profileFields) {
        if (profileFields == null) {
            return getClient().getProfileByUrl(url, profileType);
        } else {
            return getClient().getProfileByUrl(url, profileType, createSet(profileFields));
        }
    }

    /**
     * Gets the profile for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     *
     * @param profileFields the profile fields
     * @return the profile for current user
     */
    @Processor
    @RequiresAccessToken
    public Person getProfileForCurrentUser(@Optional List<ProfileField> profileFields) {
        if (profileFields == null) {
            return getClient().getProfileForCurrentUser();
        } else {
            return getClient().getProfileForCurrentUser(createSet(profileFields));
        }
    }

    /**
     * Gets the profile by API request.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     *
     * @param apiRequest the api request
     * @return the profile by api request
     */
    @Processor
    @RequiresAccessToken
    public Person getProfileByApiRequest(ApiStandardProfileRequest apiRequest) {
        // TODO
        return null;

    }


    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     *
     * @param updateTypes       the update types
     * @param start             the start, needs to be specified together with count
     * @param count             the count  needs to be specified together with start
     * @param startDate         the start date, needs to be specified together with end date
     * @param endDate           the end date, needs to be specified together with start data
     * @param showHiddenMembers
     * @return the network updates
     */
    @Processor
    @RequiresAccessToken
    public Network getNetworkUpdates(@Optional List<NetworkUpdateType> updateTypes,
                                     @Optional Integer start,
                                     @Optional Integer count,
                                     @Optional String startDate,
                                     @Optional String endDate,
                                     @Optional Boolean showHiddenMembers) {
        if (updateTypes != null && start != null && count != null && startDate != null && endDate != null && showHiddenMembers != null) {
            return getClient().getNetworkUpdates(createSet(updateTypes), start, count, createDate(startDate), createDate(endDate), showHiddenMembers);
        }
        if (updateTypes != null && start != null && count != null && startDate != null && endDate != null) {
            getClient().getNetworkUpdates(createSet(updateTypes), start, count, createDate(startDate), createDate(endDate));
        }
        if (updateTypes != null && start != null && count != null) {
            return getClient().getNetworkUpdates(createSet(updateTypes), start, count);
        }
        if (updateTypes != null && startDate != null && endDate != null) {
            return getClient().getNetworkUpdates(createSet(updateTypes), createDate(startDate), createDate(endDate));
        }
        if (start != null && count != null) {
            return getClient().getNetworkUpdates(start, count);
        }
        if (startDate != null && endDate != null) {
            return getClient().getNetworkUpdates(createDate(startDate), createDate(endDate));
        }
        if (updateTypes != null) {
            return getClient().getNetworkUpdates(createSet(updateTypes));
        }
        return getClient().getNetworkUpdates();
    }

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     *
     * @param updateTypes the update types
     * @param start       the start
     * @param count       the count
     * @param startDate   the start date
     * @param endDate     the end date
     * @return the network updates
     */
    @Processor
    @RequiresAccessToken
    public Network getUserUpdates(@Optional List<NetworkUpdateType> updateTypes,
                                  @Optional Integer start,
                                  @Optional Integer count,
                                  @Optional String startDate,
                                  @Optional String endDate) {
        if (updateTypes != null && start != null && count != null && startDate != null && endDate != null) {
            return getClient().getUserUpdates(createSet(updateTypes), start, count, createDate(startDate), createDate(endDate));
        }
        if (updateTypes != null && start != null && count != null) {
            return getClient().getUserUpdates(createSet(updateTypes), start, count);
        }
        if (updateTypes != null && startDate != null && endDate != null) {
            return getClient().getUserUpdates(createSet(updateTypes), createDate(startDate), createDate(endDate));
        }
        if (startDate != null && endDate != null) {
            return getClient().getUserUpdates(createDate(startDate), createDate(endDate));
        }
        if (start != null && count != null) {
            return getClient().getUserUpdates(start, count);
        }
        if (updateTypes != null) {
            return getClient().getUserUpdates(createSet(updateTypes));
        }
        return getClient().getUserUpdates();
    }

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     *
     * @param id
     * @param updateTypes the update types
     * @param start       the start
     * @param count       the count
     * @param startDate   the start date
     * @param endDate     the end date
     * @return the network updates
     */
    @Processor
    @RequiresAccessToken
    public Network getUserUpdatesById(String id,
                                      @Optional List<NetworkUpdateType> updateTypes,
                                      @Optional Integer start,
                                      @Optional Integer count,
                                      @Optional String startDate,
                                      @Optional String endDate) {
        if (updateTypes != null && start != null && count != null && startDate != null && endDate != null) {
            return getClient().getUserUpdates(id, createSet(updateTypes), start, count, createDate(startDate), createDate(endDate));
        }
        if (updateTypes != null && start != null && count != null) {
            return getClient().getUserUpdates(id, createSet(updateTypes), start, count);
        }
        if (updateTypes != null && startDate != null && endDate != null) {
            return getClient().getUserUpdates(id, createSet(updateTypes), createDate(startDate), createDate(endDate));
        }
        if (start != null && count != null) {
            return getClient().getUserUpdates(id, start, count);
        }
        if (startDate != null && endDate != null) {
            return getClient().getUserUpdates(id, createDate(startDate), createDate(endDate));
        }
        if (updateTypes != null) {
            return getClient().getUserUpdates(id, createSet(updateTypes));
        }
        return getClient().getUserUpdates(id);
    }

    /**
     * Gets the network update comments.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1043">http://developer.linkedin.com/docs/DOC-1043</a>
     *
     * @param networkUpdateId the network update id
     * @return the network update comments
     */
    @Processor
    @RequiresAccessToken
    public UpdateComments getNetworkUpdateComments(String networkUpdateId) {
        return getClient().getNetworkUpdateComments(networkUpdateId);
    }

    /**
     * Gets the network update likes.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1043">http://developer.linkedin.com/docs/DOC-1043</a>
     *
     * @param networkUpdateId the network update id
     * @return the network update likes
     */
    @Processor
    @RequiresAccessToken
    public Likes getNetworkUpdateLikes(String networkUpdateId) {
        return getClient().getNetworkUpdateLikes(networkUpdateId);
    }

    /**
     * Gets the connections for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     *
     * @param profileFields    the profile fields
     * @param start            the start
     * @param count            the count
     * @param modificationDate
     * @param modificationType
     * @return the connections for current user
     */
    @Processor
    @RequiresAccessToken
    public Connections getConnectionsForCurrentUser(@Optional List<ProfileField> profileFields,
                                                    @Optional Integer start,
                                                    @Optional Integer count,
                                                    @Optional String modificationDate,
                                                    @Optional ConnectionModificationType modificationType) {
        if (profileFields != null && start != null && count != null && modificationDate != null && modificationType != null) {
            return getClient().getConnectionsForCurrentUser(createSet(profileFields), start, count, createDate(modificationDate), modificationType);
        }
        if (profileFields != null && modificationDate != null && modificationType != null) {
            return getClient().getConnectionsForCurrentUser(createSet(profileFields), createDate(modificationDate), modificationType);
        }
        if (profileFields != null && start != null && count != null) {
            return getClient().getConnectionsForCurrentUser(createSet(profileFields), start, count);
        }
        if (start != null && count != null && modificationDate != null && modificationType != null) {
            return getClient().getConnectionsForCurrentUser(start, count, createDate(modificationDate), modificationType);
        }
        if (start != null && count != null) {
            return getClient().getConnectionsForCurrentUser(start, count);
        }
        if (modificationDate != null && modificationType != null) {
            return getClient().getConnectionsForCurrentUser(createDate(modificationDate), modificationType);
        }
        if (profileFields != null) {
            return getClient().getConnectionsForCurrentUser(createSet(profileFields));
        }
        return getClient().getConnectionsForCurrentUser();
    }

    /**
     * Gets the connections by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     *
     * @param id               the id
     * @param profileFields    the profile fields
     * @param start            the start
     * @param count            the count
     * @param modificationDate
     * @param modificationType
     * @return the connections by id
     */
    @Processor
    @RequiresAccessToken
    public Connections getConnectionsById(String id,
                                          @Optional List<ProfileField> profileFields,
                                          @Optional Integer start,
                                          @Optional Integer count,
                                          @Optional String modificationDate,
                                          @Optional ConnectionModificationType modificationType) {
        if (profileFields != null && start != null && count != null && modificationDate != null && modificationType != null) {
            return getClient().getConnectionsById(id, createSet(profileFields), start, count, createDate(modificationDate), modificationType);
        }
        if (profileFields != null && modificationDate != null && modificationType != null) {
            return getClient().getConnectionsById(id, createSet(profileFields), createDate(modificationDate), modificationType);
        }
        if (profileFields != null && start != null && count != null) {
            return getClient().getConnectionsById(id, createSet(profileFields), start, count);
        }
        if (start != null && count != null && modificationDate != null && modificationType != null) {
            return getClient().getConnectionsById(id, start, count, createDate(modificationDate), modificationType);
        }
        if (modificationDate != null && modificationType != null) {
            return getClient().getConnectionsById(id, createDate(modificationDate), modificationType);
        }
        if (start != null && count != null) {
            return getClient().getConnectionsById(id, start, count);
        }
        if (profileFields != null) {
            return getClient().getConnectionsById(id, createSet(profileFields));
        }
        return getClient().getConnectionsById(id);
    }

    /**
     * Gets the connections by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     *
     * @param url              the url
     * @param profileFields    the profile fields
     * @param start            the start
     * @param count            the count
     * @param modificationDate
     * @param modificationType
     * @return the connections by url
     */
    @Processor
    @RequiresAccessToken
    public Connections getConnectionsByUrl(String url,
                                           @Optional List<ProfileField> profileFields,
                                           @Optional Integer start,
                                           @Optional Integer count,
                                           @Optional String modificationDate,
                                           @Optional ConnectionModificationType modificationType) {
        if (profileFields != null && start != null && count != null && modificationDate != null && modificationType != null) {
            return getClient().getConnectionsByUrl(url, createSet(profileFields), start, count, createDate(modificationDate), modificationType);
        }
        if (profileFields != null && modificationDate != null && modificationType != null) {
            return getClient().getConnectionsByUrl(url, createSet(profileFields), createDate(modificationDate), modificationType);
        }
        if (profileFields != null && start != null && count != null) {
            return getClient().getConnectionsByUrl(url, createSet(profileFields), start, count);
        }
        if (start != null && count != null && modificationDate != null && modificationType != null) {
            return getClient().getConnectionsByUrl(url, start, count, createDate(modificationDate), modificationType);
        }
        if (modificationDate != null && modificationType != null) {
            return getClient().getConnectionsByUrl(url, createDate(modificationDate), modificationType);
        }
        if (start != null && count != null) {
            return getClient().getConnectionsByUrl(url, start, count);
        }
        if (profileFields != null) {
            return getClient().getConnectionsByUrl(url, createSet(profileFields));
        }
        return getClient().getConnectionsByUrl(url);
    }

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     *
     * @param searchParameters the search parameters
     * @param profileFields
     * @param start            the start
     * @param count            the count
     * @param sortOrder        the sort order
     * @return the people
     */
    @Processor
    @RequiresAccessToken
    public People searchPeople(@Optional Map<SearchParameter, String> searchParameters,
                               @Optional List<ProfileField> profileFields,
                               @Optional Integer start,
                               @Optional Integer count,
                               SearchSortOrder sortOrder) {
        if (searchParameters != null && profileFields != null && start != null && count != null) {
            return getClient().searchPeople(searchParameters, createSet(profileFields), start, count, sortOrder);
        }
        if (searchParameters != null && profileFields != null) {
            return getClient().searchPeople(searchParameters, createSet(profileFields), sortOrder);
        }
        if (searchParameters != null && start != null && count != null) {
            return getClient().searchPeople(searchParameters, start, count, sortOrder);
        }
        if (searchParameters != null) {
            return getClient().searchPeople(searchParameters, sortOrder);
        }
        return getClient().searchPeople();
    }

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     *
     * @param searchParameters the search parameters
     * @param profileFields
     * @param start            the start
     * @param count            the count
     * @param sortOrder        the sort order, defaults to RELEVANCE
     * @param facets           the facet type and a comma separated string
     * @return the people
     */

    @Processor
    @RequiresAccessToken
    public People searchPeopleWithFacets(Map<SearchParameter, String> searchParameters,
                                         @Optional List<ProfileField> profileFields,
                                         @Optional Integer start,
                                         @Optional Integer count,
                                         @Optional SearchSortOrder sortOrder,
//                                         List<Parameter<FacetType, String>> facets) {
                                         Map<FacetType, String> facets) {
        if (sortOrder == null) {
            sortOrder = SearchSortOrder.RELEVANCE;
        }
        if (profileFields != null && start != null && count != null) {
            return getClient().searchPeople(searchParameters, createSet(profileFields), start, count, sortOrder, adapt(facets));
        }
        if (profileFields != null) {
            return getClient().searchPeople(searchParameters, createSet(profileFields), sortOrder, adapt(facets));
        }
        if (start != null && count != null) {
            return getClient().searchPeople(searchParameters, start, count, sortOrder, adapt(facets));
        }
        return getClient().searchPeople(searchParameters, sortOrder, adapt(facets));
    }

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     *
     * @param searchParameters the search parameters
     * @param profileFields
     * @param facetFields
     * @param start            the start
     * @param count            the count
     * @param sortOrder        the sort order, defaults to RELEVANCE
     * @param facets
     * @return the people
     */

    @Processor
    @RequiresAccessToken
    public PeopleSearch searchPeopleWithFacetFields(Map<SearchParameter, String> searchParameters,
                                                    List<ProfileField> profileFields,
                                                    List<FacetField> facetFields,
                                                    @Optional Integer start,
                                                    @Optional Integer count,
                                                    @Optional SearchSortOrder sortOrder,
                                                    @Optional Map<FacetType, String> facets) {
        if (sortOrder == null) {
            sortOrder = SearchSortOrder.RELEVANCE;
        }
        if (start != null && count != null && facets != null) {
            return getClient().searchPeople(searchParameters, createSet(profileFields), createSet(facetFields), start, count, sortOrder, adapt(facets));
        }
        if (start != null && count != null) {
            return getClient().searchPeople(searchParameters, createSet(profileFields), createSet(facetFields), start, count, sortOrder);
        }
        if (facets != null) {
            return getClient().searchPeople(searchParameters, createSet(profileFields), createSet(facetFields), sortOrder, adapt(facets));
        }
        return getClient().searchPeople(searchParameters, createSet(profileFields), createSet(facetFields), sortOrder);
    }

    /**
     * Post network update.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1009">http://developer.linkedin.com/docs/DOC-1009</a>
     *
     * @param updateText the update text
     */
    @Processor
    @RequiresAccessToken
    public void postNetworkUpdate(String updateText) {
        getClient().postNetworkUpdate(updateText);
    }

    /**
     * Post comment.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1043">http://developer.linkedin.com/docs/DOC-1043</a>
     *
     * @param networkUpdateId the network update id
     * @param commentText     the comment text
     */
    @Processor
    @RequiresAccessToken
    public void postComment(String networkUpdateId, String commentText) {
        getClient().postComment(networkUpdateId, commentText);
    }

    /**
     * Like post.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1043">http://developer.linkedin.com/docs/DOC-1043</a>
     *
     * @param networkUpdateId the network update id
     */
    @Processor
    @RequiresAccessToken
    public void likePost(String networkUpdateId) {
        getClient().likePost(networkUpdateId);
    }

    /**
     * Unlike post.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1043">http://developer.linkedin.com/docs/DOC-1043</a>
     *
     * @param networkUpdateId the network update id
     */
    @Processor
    @RequiresAccessToken
    public void unlikePost(String networkUpdateId) {
        getClient().unlikePost(networkUpdateId);
    }

    /**
     * Update current status.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1007">http://developer.linkedin.com/docs/DOC-1007</a>
     *
     * @param status        the status
     * @param postToTwitter whether to post the update to Twitter
     */
    @Processor
    @RequiresAccessToken
    public void updateCurrentStatus(String status, @Optional @Default("false") Boolean postToTwitter) {
        getClient().updateCurrentStatus(status, postToTwitter);
    }

    /**
     * Delete current status.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1007">http://developer.linkedin.com/docs/DOC-1007</a>
     */
    @Processor
    @RequiresAccessToken
    public void deleteCurrentStatus() {
        getClient().deleteCurrentStatus();
    }

    /**
     * Send message.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1044">http://developer.linkedin.com/docs/DOC-1044</a>
     *
     * @param recepientIds the recepient ids
     * @param subject      the subject
     * @param message      the message
     */
    @Processor
    @RequiresAccessToken
    public void sendMessage(List<String> recepientIds, String subject, String message) {
        getClient().sendMessage(recepientIds, subject, message);
    }

    /**
     * Send invite.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1012">http://developer.linkedin.com/docs/DOC-1012</a>
     *
     * @param email     the email
     * @param firstName the first name
     * @param lastName  the last name
     * @param subject   the subject
     * @param message   the message
     */
    @Processor
    @RequiresAccessToken
    public void sendInviteByEmail(String email, String firstName, String lastName, String subject, String message) {
        getClient().sendInviteByEmail(email, firstName, lastName, subject, message);
    }

    /**
     * Post share.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1212">http://developer.linkedin.com/docs/DOC-1212</a>
     *
     * @param commentText   the comment text
     * @param title         the title
     * @param url           the url
     * @param imageUrl      the image url
     * @param visibility    the visibility
     * @param postToTwitter
     */
    @Processor
    @RequiresAccessToken
    public void postShare(String commentText, String title, String url, String imageUrl, VisibilityType visibility, @Optional @Default("false") Boolean postToTwitter) {
        getClient().postShare(commentText, title, url, imageUrl, visibility, postToTwitter);
    }

    /**
     * Re-share.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1212">http://developer.linkedin.com/docs/DOC-1212</a>
     *
     * @param shareId     the share id
     * @param commentText
     * @param visibility  the visibility
     */
    @Processor
    @RequiresAccessToken
    public void reShare(String shareId, String commentText, VisibilityType visibility) {
        getClient().reShare(shareId, commentText, visibility);
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    private Date createDate(String dateString) {
        // TODO
        return null;
    }

    private <T> Set<T> createSet(List<T> list) {
        Set<T> set = new HashSet<T>(list.size());
        set.addAll(list);
        return set;
    }

    private List<Parameter<FacetType, String>> adapt(Map<FacetType, String> facets) {
        List<Parameter<FacetType, String>> facetList = new ArrayList<Parameter<FacetType, String>>();
        for (Map.Entry<FacetType, String> entry : facets.entrySet()) {
            String facetValuesCommaSeparated = entry.getValue();
            for (String facetValue : facetValuesCommaSeparated.split(",")) {
                facetList.add(new Parameter<FacetType, String>(entry.getKey(), facetValue));
            }
        }
        return facetList;
    }

    private synchronized LinkedInApiClient getClient() {
        if (client == null) {
            client = LinkedInClientFactory.getClient(apiKey, apiSecret, accessToken, accessTokenSecret);
        }
        return client;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        client = null;
    }

    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }
}